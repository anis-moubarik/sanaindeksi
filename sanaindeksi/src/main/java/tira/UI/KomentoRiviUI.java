package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;
import tira.dynaaminentaulu.DynaaminenTauluString;
import tira.fileIO.TiedostonLuku;
import tira.trie.Trie;
import tira.trie.TrieSolmu;

/**
 * 
 * @author moubarik
 */
public class KomentoRiviUI{
    private Trie tr = new Trie();
    DynaaminenTauluInterface<String> komennot = new DynaaminenTauluString();
    String[] tiedostot = {};
    private InputStream in;
    
    /**
     * Testauksen helpottamiseksi käytetään dependency injectionia luokan alustamisessa.
     */
    public KomentoRiviUI(InputStream in){
        komennot.lisää("hae"); komennot.lisää("lataa"); komennot.lisää("lopeta");
        this.in = in;
    }
    
        public KomentoRiviUI(){
            this(System.in);
        }
    
    /**
     * 
     * @throws IOException
     */
    public void run() throws IOException{
        String s;
        Scanner sc = new Scanner(in);
        boolean run = true;
        while(run == true){
            System.out.print("> ");
            s = sc.nextLine();
            System.out.println(s);
            if(!s.equals("") && !s.equals("lopeta"))
                prosessoiKomento(s);
            else if(s.equals("lopeta"))
                run = false;
        }
    }

    /**
     * Etsitään parametrina annettua sanaa Trie puusta. Palauttaa rivinumerot ja rivin näytölle.
     * @param etsittäväSana 
     */
    private void etsi(String etsittäväSana){
        long alku = System.currentTimeMillis();
        TrieSolmu s = tr.etsiSolmu(etsittäväSana);
        long loppu = System.currentTimeMillis();
        
        if(s == null){
            System.out.println("Ei löytynyt!");
            return;
        }
        int rivityhteensä = 0;
        DynaaminenTauluInterface<Integer> dt;
        Iterator it = s.getTiedostoJaRivinumerot().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pairs = (Map.Entry) it.next();
            dt = (DynaaminenTauluInt) pairs.getValue();
            for(int i = 0; i < dt.size()-1; i++){
                String[] rivit = tr.tiedostoJaRivit.get((String)pairs.getKey());
                System.out.println(rivit[dt.hae(i)]);
            }
        }
        
        System.out.println("Haussa kesti: "+(loppu-alku)+"ms. Yhteensä "+rivityhteensä+" riviä.");
        
    }
    
    /**
     * @param tiedosto
     * @throws IOException
     */
    private void lataa(String tiedosto) throws IOException{
        TiedostonLuku tl = new TiedostonLuku();
        String[] teksti;
        try {
            teksti = tl.lueRivitTaulukkoon(tiedosto);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt!");
            return;
        }
        System.out.println("Ladataan tiedostoa...");
        long start = System.currentTimeMillis();
        tr.lisääSanat(tiedosto, teksti);
        long end = System.currentTimeMillis();
        System.out.println("Ladattu. Aikaa meni "+(end-start)+"ms");
    }
    
    /**
     * Metodi ottaa String komennon jolla ohjelmaa ohjataan.
     * @param in
     */
    private void prosessoiKomento(String in) throws IOException {
        String[] komentoJaParametrit = in.split(" ");
        if(!komennot.sisältää(komentoJaParametrit[0])){
            System.out.println("Komentoa: \""+komentoJaParametrit[0]+"\" ei tunnistettu.");
        }else if(komentoJaParametrit.length > 2){
            System.out.println("Liikaa parametreja.");
        }else if(komentoJaParametrit.length == 1){
            System.out.println("Et antanut yhtään parametria.");
        }else if(komentoJaParametrit[0].equals("lataa")){
            lataa(komentoJaParametrit[1]);
        }else if(komentoJaParametrit[0].equals("hae")){
            etsi(komentoJaParametrit[1]);
        }
        
    }
}