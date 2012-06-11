package tira.trie;

import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;
import tira.hajautustaulu.HajautusMapDT;

/**
 * 
 * @author Anis
 */
public class TrieSolmu{


    private char kirjain;
    /**
     * DynaaminenTaulu joka sisältää solmun lapset
     */
    private DynaaminenTauluInterface<TrieSolmu> lapset;

    /**
     * Kertoo onko solmuun asti kuljettu reitti kokonainen sana.
     */
    public boolean onkoSana;
    /**
     * HajautusMapDT jossa on rivi ja tekstit järjestyksessä.
     */
    private HajautusMapDT tiedostoJaRivinumerot;

    
    /**
     * Lisätään taulukkoon tiedosto ja rivinnumero mistä rivin löytää.
     * @param s
     * @param i
     */
    public void lisääTiedostoJaRivinumero(String s, int i){
        DynaaminenTauluInt e = tiedostoJaRivinumerot.get(s);
        if(e == null)
            e = new DynaaminenTauluInt();
        e.lisää(i);
        tiedostoJaRivinumerot.put(s, e);
    }
    
    
    /**
     * 
     * @param kirjain
     * @param onkoSana
     */
    public TrieSolmu(char kirjain, boolean onkoSana){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        this.tiedostoJaRivinumerot = new HajautusMapDT(50);
    }

    /**
     * Palautetaan solmun kirjain.
     * @return char
     */
    public char getKirjain() {
        return kirjain;
    }

    /**
     * Asetetaan solmun kirjain
     * @param kirjain
     */
    public void setKirjain(char kirjain) {
        this.kirjain = kirjain;
    }

    /**
     * Palauttaa dynaamisessa taulussa olevat solmun lapset.
     * @return
     */
    public DynaaminenTauluInterface<TrieSolmu> getLapset() {
        return lapset;
    }

    /**
     * Asetetaan solmun lapset.
     * @param lapset
     */
    public void setLapset(DynaaminenTauluInterface lapset) {
        this.lapset = lapset;
    }

    /**
     * Palauttaa true, jos solmu on merkitty sanaksi.
     * @return boolean
     */
    public boolean isOnkoSana() {
        return onkoSana;
    }

    /**
     * Asetetaan kirjaimen sana totuusarvo.
     * @param onkoSana
     */
    public void setOnkoSana(boolean onkoSana) {
        this.onkoSana = onkoSana;
    }
    
    /**
     * Palautetaan tiedostoJaRivinumerot HajautusMapDT.
     * @return
     */
    public HajautusMapDT getTiedostoJaRivinumerot() {
        return tiedostoJaRivinumerot;
    }

    /**
     * Asetetaan parametrina saatu HajautusMapDT uudeksi tiedostoJaRivinumerot muuttujaksi.
     * @param tiedostoJaRivinumerot
     */
    public void setTiedostoJaRivinumerot(HajautusMapDT tiedostoJaRivinumerot) {
        this.tiedostoJaRivinumerot = tiedostoJaRivinumerot;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrieSolmu other = (TrieSolmu) obj;
        if (this.kirjain != other.kirjain) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.kirjain;
        return hash;
    }
    
}