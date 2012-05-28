package tira.trie;

import java.util.LinkedList;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

/**
 * 
 * @author Anis
 */
public class TrieSolmu{
    
    char kirjain;
    DynaaminenTauluInterface lapset;
    boolean onkoSana;
    LinkedList<Integer> rivit = new LinkedList<Integer>();
    
    /**
     * 
     * @param kirjain
     * @param onkoSana
     * @param rivi
     */
    public TrieSolmu(char kirjain, boolean onkoSana, int rivi){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        rivit.add(rivi);
    }

    /**
     * 
     * @return
     */
    public char getKirjain() {
        return kirjain;
    }

    /**
     * 
     * @param kirjain
     */
    public void setKirjain(char kirjain) {
        this.kirjain = kirjain;
    }

    /**
     * 
     * @return
     */
    public DynaaminenTauluInterface getLapset() {
        return lapset;
    }

    /**
     * 
     * @param lapset
     */
    public void setLapset(DynaaminenTauluInterface lapset) {
        this.lapset = lapset;
    }

    /**
     * 
     * @return
     */
    public boolean isOnkoSana() {
        return onkoSana;
    }

    /**
     * 
     * @param onkoSana
     */
    public void setOnkoSana(boolean onkoSana) {
        this.onkoSana = onkoSana;
    }

    /**
     * 
     * @return
     */
    public LinkedList getRivit() {
        return rivit;
    }

    /**
     * 
     * @param rivit
     */
    public void setRivit(LinkedList rivit) {
        this.rivit = rivit;
    }
    
    /**
     * 
     * @param rivi
     */
    public void lisääRivi(int rivi){
        rivit.add(rivi);
    }
    
}