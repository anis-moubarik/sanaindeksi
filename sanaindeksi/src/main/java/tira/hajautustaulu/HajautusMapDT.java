
package tira.hajautustaulu;

import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 *
 * @author moubarik
 */
public class HajautusMapDT {

    private TiedostoRiviNumeroEntry[] taulu;
    private int koko;
    private final double loadFactor = 0.8;
    private int täyttö;

    /**
     * Konstruktori joka luo taulun parametrin koon mukaan.
     * @param koko
     */
    public HajautusMapDT(int koko) {
        taulu = new TiedostoRiviNumeroEntry[koko];
        this.koko = koko;
    }

    /**
     * Konstruktori ilman parametrejä.
     */
    public HajautusMapDT() {
        this(10);
    }
    
    /**
     * Palautetaan Entry taulukko.
     * @return TiedostoRiviNumeroEntry[]
     */
    public TiedostoRiviNumeroEntry[] getTaulukko(){
        return taulu;
    }

    
    /**
     * Rehash funktio jota käytetään, kun taulun täyttö ylittää loadFactorin (0.8).
     * Luodaan uusi, kaksi kertaa isompi taulukko ja uudelleen hajautetaan arvot vanhasta taulusta.
     */
    private void rehash() {
        TiedostoRiviNumeroEntry[] apu = taulu;
        taulu = new TiedostoRiviNumeroEntry[koko*2];
        koko = koko*2;
        for (int i = 0; i < apu.length; i++) {
            if(apu[i] == null)
                continue;
            put((String)apu[i].getKey(), (DynaaminenTauluInt)apu[i].getValue());
        }
    }
    
    /**
     * Lisätään tauluu parametrinä saadut tiedostonimi sekä rivi -dynaaminentaulukko.
     * @param tiedosto
     * @param rivit
     */
    public void put(String tiedosto, DynaaminenTauluInterface<Integer> rivit) {
        int hash = (mjToInt(tiedosto) % koko);

        while (taulu[hash] != null && taulu[hash].getKey() != tiedosto) {
            hash = (hash + 1) % koko;
        }
        taulu[hash] = new TiedostoRiviNumeroEntry(tiedosto, rivit);
        täyttö++;
        
        if(loadFactor < (täyttö / koko))
            rehash();
    }

    /**
     * Haetaan taulukosta avaimen perusteella value.
     * @param key
     * @return
     */
    public DynaaminenTauluInterface<Integer> get(String key) {
        int hash = (mjToInt(key) % koko);
        while(taulu[hash] != null && taulu[hash].getKey() != key)
            hash = (hash + 1) % koko;
        if(taulu[hash] == null)
            return null;
        else
            return (DynaaminenTauluInt)taulu[hash].getValue();
    }

    /**
     * Muutetaan parametrinä saatu merkkijono kokonaisluvuksi.
     * @param s
     * @return 
     */
    private int mjToInt(String s) {
        char[] c = s.toCharArray();
        if(c.length <= 0)
            return 0;
        int summa = ascii(c[0]) + 128;

        if (c.length >= 3) {
            for (int i = 1; i < 3; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);

            }
        } else {
            for (int i = 0; i < c.length; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);

            }
        }

        return summa;
    }

    /**
     * Mutetaan char muuttuja ascii koodiksi.
     * @param c
     * @return 
     */
    private int ascii(char c) {
        return c - 64;
    }

}
