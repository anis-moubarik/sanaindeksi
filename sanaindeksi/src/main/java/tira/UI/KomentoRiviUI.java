package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
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
     * @param in 
     */
    public KomentoRiviUI(InputStream in){
        komennot.lisää("hae"); komennot.lisää("lataa"); komennot.lisää("lopeta");
        this.in = in;
    }
    
    /**
     * Annetaan System.in InputStreamiksi.
     */
    public KomentoRiviUI(){
            this(System.in);
        }
    
    /**
     * Käynnistetään pää- while-looppi joka prosessoi käyttäjän antamat komennot.
     * @throws IOException
     */
    public void run() throws IOException{
        String s;
        Scanner sc = new Scanner(in);
        boolean run = true;
        while(run == true){
            System.out.print("> ");
            s = sc.nextLine();
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
        
        if(s == null){
            System.out.println("Ei löytynyt!");
            return;
        }
        
        int rivityhteensä = 0;
        DynaaminenTauluInterface<Integer> dt;
        
        //Haetaan hashmapin iteraattori, ja lähdetään tulostamaan löydettyjä rivejä
        LinkedList<Map.Entry>[] taulu = s.getTiedostoJaRivinumerot().getTaulukko();
        
        for(int i = 0; i < taulu.length; i++){
            Map.Entry pairs = (Map.Entry) taulu[i];
            dt = (DynaaminenTauluInt) pairs.getValue();
            for (int j = 0; j < dt.size(); j++) {
                String[] rivit = tr.getTiedostoJaRivit().get((String)pairs.getKey());
               /*Tulostetaan pairs muuttujan avain, joka on tiedostonnimi, ja 
                * haetaan dynaamisesta taulukosta rivi. Haetaan myös rivit taulukosta
                * rivin määräämältä kohdalta merkkijono.
                */
                System.out.println(pairs.getKey()+":"+dt.hae(i)+":"+rivit[dt.hae(i)-1]);
                rivityhteensä++;
                
            }
            if(s.getLapset().hae(i) == null)
                break;
            taulu = s.getLapset().hae(i).getTiedostoJaRivinumerot().getTaulukko();
        }
        
        long loppu = System.currentTimeMillis();
        int j = 0;
        
        System.out.println("Haussa kesti: "+(loppu-alku)+"ms. Yhteensä "+rivityhteensä+" riviä.");
        
    }
    
    /**
     * Ladataan String taulukosta kaikki tiedostot Trieen.
     * @param tiedostot
     * @throws IOException
     */
    public void lataaParametrit(String[] tiedostot) throws IOException{
        for(String tiedosto : tiedostot){
            lataa(tiedosto);
        }
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
     * Ottaa String komennon jolla ohjelmaa ohjataan.
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