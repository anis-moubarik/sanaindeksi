package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import tira.fileIO.TiedostonLuku;
import tira.trie.Trie;
import tira.trie.TrieSolmu;

/**
 * 
 * @author moubarik
 */
public class KomentoRiviUI{
    private Trie tr = new Trie();
    ArrayList<String> komennot = new ArrayList<String>();
    
    /**
     * 
     */
    public KomentoRiviUI(){
        komennot = new ArrayList<String>();
        komennot.add("hae"); komennot.add("lataa"); komennot.add("lopeta");
    }
    
    /**
     * 
     * @throws IOException
     */
    public void run() throws IOException{
        String in;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("> ");
            in = sc.nextLine();
            if(!in.equals("") && !in.equals("lopeta"))
                prosessoiKomento(in);
            else
                System.exit(0);
        }
    }

    private void etsi(String etsittäväSana){
        LinkedList<Integer> kaikkiRivit = new LinkedList<Integer>();
        TrieSolmu s = tr.etsiSolmu(etsittäväSana);
        
        kaikkiRivit = s.getRivit();
        
        for(int i = 0; i < s.getLapset().size(); i++){
            for (int j = 0; j < s.getLapset().hae(i).getRivit().size(); j++) {
               kaikkiRivit.add((Integer)s.getLapset().hae(i).getRivit().get(j)); 
            }
        }
        
        Collections.sort(kaikkiRivit);
        
        System.out.print("\n\nRivit "+etsittäväSana+": ");
        int i = 0;
        for(int rivi : kaikkiRivit){
            if((i%5) == 0) System.out.println("");
            System.out.print(rivi+", ");
            i++;
        }
        System.out.println("");
    }
    
    /**
     * @param tiedosto
     * @throws IOException
     */
    public void lataa(String tiedosto) throws IOException{
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
        tr.lisääSanat(teksti);
        long end = System.currentTimeMillis();
        System.out.println("Ladattu. Aikaa meni "+(end-start)+"ms");
    }
    
    /**
     * Metodi ottaa String komennon jolla ohjelmaa ohjataan.
     * @param in
     */
    private void prosessoiKomento(String in) throws IOException {
        String[] komentoJaParametrit = in.split(" ");
        if(!komennot.contains(komentoJaParametrit[0])){
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