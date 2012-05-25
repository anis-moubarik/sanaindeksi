package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import tira.fileIO.TiedostonLuku;
import tira.trie.Trie;

public class KomentoRiviUI{
    private Trie tr = new Trie();
    
    public void run() throws IOException{
        String komento;
        ArrayList<String> komennot = new ArrayList<String>();
        komennot.add("hae"); komennot.add("lataa"); komennot.add("lopeta");
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("> ");
            komento = sc.next();
            String parametri = sc.next();
            if(!komennot.contains(komento)){
                System.out.println("Komentoa: \""+komento+"\" ei löydy");
            }
            if(komento.equals("lataa")){
                lataa(parametri);
            }
        }
    }
    
    private void etsi(){
        
    }
    
    public void lataa(String tiedosto) throws IOException{
        TiedostonLuku tl = new TiedostonLuku();
        String[] teksti = {};
        
        //Loggeri
        Logger logger = Logger.getLogger("sanaindeksi");
        FileHandler fh = new FileHandler("sanaindeksi.log", true);
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        try {
            teksti = tl.lueRivitTaulukkoon(tiedosto);
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println(logger.getParent());
            System.out.println("Tiedostoa ei löytynyt!");
            return;
        }
        System.out.println("Ladataan tiedostoa...");
        long start = System.currentTimeMillis();
        tr.lisääSanat(teksti);
        long end = System.currentTimeMillis();
        System.out.println("Ladattu. Aikaa meni "+(end-start)+"ms");
    }
}