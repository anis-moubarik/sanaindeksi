package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import tira.fileIO.TiedostonLuku;
import tira.trie.Trie;

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
            if(!in.equals(""))
                prosessoiKomento(in);
        }
    }

    private void etsi(){
        
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
        }
        
    }
}