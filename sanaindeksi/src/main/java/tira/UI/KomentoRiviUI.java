package tira.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;
import tira.dynaaminentaulu.DynaaminenTauluString;
import tira.fileIO.TiedostonLuku;
import tira.hajautustaulu.TiedostoRiviNumeroEntry;
import tira.trie.Trie;
import tira.trie.TrieSolmu;

/**
 *
 * @author moubarik
 */
public class KomentoRiviUI {

    private Trie tr = new Trie();
    DynaaminenTauluInterface<String> komennot = new DynaaminenTauluString();
    private InputStream in;

    /**
     * Testauksen helpottamiseksi käytetään dependency injectionia luokan
     * alustamisessa.
     *
     * @param in
     */
    public KomentoRiviUI(InputStream in) {
        komennot.lisää("hae");
        komennot.lisää("lataa");
        komennot.lisää("lopeta");
        this.in = in;
    }

    /**
     * Annetaan System.in InputStreamiksi.
     */
    public KomentoRiviUI() {
        this(System.in);
    }

    /**
     * Käynnistetään pää- while-looppi joka prosessoi käyttäjän antamat
     * komennot.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        String s;
        Scanner sc = new Scanner(in);
        boolean run = true;
        while (run == true) {
            System.out.print("> ");
            s = sc.nextLine();
            if (!s.equals("") && !s.equals("lopeta")) {
                prosessoiKomento(s);
            } else if (s.equals("lopeta")) {
                run = false;
            }
        }
    }

    /**
     * Otetaan kaksi parametria ja etsitään niiden leikkaus, eli rivit joissa esiintyy molemmat sanat.
     */
    private void intersection(String eka, String toka) {
        TrieSolmu ekaSolmu = tr.etsiSolmu(eka);
        TrieSolmu tokaSolmu = tr.etsiSolmu(toka);
        if (ekaSolmu == null && tokaSolmu == null) {
            System.out.println("Ei löytynyt kumpaakaan!");
            return;
        }
        TiedostoRiviNumeroEntry[] ekaRivit = ekaSolmu.getTiedostoJaRivinumerot().getTaulukko();
        TiedostoRiviNumeroEntry[] tokaRivit = tokaSolmu.getTiedostoJaRivinumerot().getTaulukko();

        DynaaminenTauluInterface<Integer> ekan, tokan;
        DynaaminenTauluInt ekanRivit = new DynaaminenTauluInt(10);
        DynaaminenTauluInt tokanRivit = new DynaaminenTauluInt(10);

        String tiedostot = "";

        for (int i = 0; i < ekaRivit.length; i++) {
            if (ekaRivit[i] == null) {
                continue;
            }
            tiedostot += ekaRivit[i].getKey() + "\t";
            ekan = (DynaaminenTauluInt) ekaRivit[i].getValue();
            for (int j = 0; j < ekan.size(); j++) {
                ekanRivit.lisää(ekan.hae(j));
            }

        }

        for (int i = 0; i < tokaRivit.length; i++) {
            if (tokaRivit[i] == null) {
                continue;
            }
            tokan = (DynaaminenTauluInt) tokaRivit[i].getValue();
            for (int j = 0; j < tokan.size(); j++) {
                tokanRivit.lisää(tokan.hae(j));
            }

        }

        DynaaminenTauluInt intersection = new DynaaminenTauluInt(25);

        for (int i = 0; i < ekanRivit.size(); i++) {
            for (int j = 0; j < tokanRivit.size(); j++) {
                if ((int) ekanRivit.hae(i) == (int) tokanRivit.hae(j)) {
                    intersection.lisää(ekanRivit.hae(i));
                }

            }
        }
        String[] files = tiedostot.split("\t");
        int rivityhteensä = 0;
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < intersection.size(); j++) {
                String[] rivit = tr.getTiedostoJaRivit().get(files[i]);
                /*
                 * Tulostetaan pairs muuttujan avain, joka on tiedostonnimi, ja
                 * haetaan dynaamisesta taulukosta rivi. Haetaan myös rivit
                 * taulukosta rivin määräämältä kohdalta merkkijono.
                 */
                System.out.println(files[i] + ":" + intersection.hae(j) + ":" + rivit[intersection.hae(j) - 1]);
                rivityhteensä++;

            }


        }
    }

        /**
         * Etsitään parametrina annettua sanaa Trie puusta. Palauttaa
         * rivinumerot ja rivin näytölle.
         *
         * @param etsittäväSana
         */
    

    private void etsi(String etsittäväSana) {
        long alku = System.currentTimeMillis();
        TrieSolmu s = tr.etsiSolmu(etsittäväSana);

        if (s == null) {
            System.out.println("Ei löytynyt!");
            return;
        }

        int rivityhteensä = 0;
        DynaaminenTauluInterface<Integer> dt;

        //Haetaan Hajautustaulun entry-taulukko ja iteroidaan se läpi.
        TiedostoRiviNumeroEntry[] taulu = s.getTiedostoJaRivinumerot().getTaulukko();
        long loppu = System.currentTimeMillis();
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i] == null) {
                continue;
            }
            Map.Entry pair = taulu[i];
            dt = (DynaaminenTauluInt) pair.getValue();
            for (int j = 0; j < dt.size(); j++) {
                String[] rivit = tr.getTiedostoJaRivit().get((String) pair.getKey());
                /*
                 * Tulostetaan pairs muuttujan avain, joka on tiedostonnimi, ja
                 * haetaan dynaamisesta taulukosta rivi. Haetaan myös rivit
                 * taulukosta rivin määräämältä kohdalta merkkijono.
                 */
                System.out.println(pair.getKey() + ":" + dt.hae(j) + ":" + rivit[dt.hae(j) - 1]);
                rivityhteensä++;

            }
        }




        System.out.println("Haussa kesti: " + (loppu - alku) + "ms. Yhteensä " + rivityhteensä + " riviä.");
    }

    /**
     * Ladataan String taulukosta kaikki tiedostot Trieen.
     *
     * @param tiedostot
     * @throws IOException
     */
    public void lataaParametrit(String[] tiedostot) throws IOException {
        for (String tiedosto : tiedostot) {
            lataa(tiedosto);
        }
    }

    /**
     * @param tiedosto
     * @throws IOException
     */
    private void lataa(String tiedosto) throws IOException {
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
        System.out.println("Ladattu. Aikaa meni " + (end - start) + "ms");
    }

    /**
     * Ottaa String komennon jolla ohjelmaa ohjataan.
     *
     * @param in
     */
    private void prosessoiKomento(String in) throws IOException {
        String[] komentoJaParametrit = in.split(" ");
        if (!komennot.sisältää(komentoJaParametrit[0])) {
            System.out.println("Komentoa: \"" + komentoJaParametrit[0] + "\" ei tunnistettu.");
        } else if (komentoJaParametrit.length > 3) {
            System.out.println("Liikaa parametreja.");
        } else if (komentoJaParametrit.length == 1) {
            System.out.println("Et antanut yhtään parametria.");
        } else if (komentoJaParametrit[0].equals("lataa")) {
            lataa(komentoJaParametrit[1]);
        } else if (komentoJaParametrit[0].equals("hae") && komentoJaParametrit.length < 3) {
            etsi(komentoJaParametrit[1]);
        } else if (komentoJaParametrit[0].equals("hae") && komentoJaParametrit.length == 3) {
            intersection(komentoJaParametrit[1], komentoJaParametrit[2]);
        }

    }
}