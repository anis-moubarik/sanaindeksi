package tira.trie;

import java.util.LinkedList;
import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

public class TrieSolmu{
    
    char kirjain;
    DynaaminenTauluInterface lapset;
    boolean onkoSana;
    LinkedList<Integer> rivit = new LinkedList<Integer>();
    
    public TrieSolmu(char kirjain, boolean onkoSana, int rivi){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        rivit.add(rivi);
    }

    public char getKirjain() {
        return kirjain;
    }

    public void setKirjain(char kirjain) {
        this.kirjain = kirjain;
    }

    public DynaaminenTauluInterface getLapset() {
        return lapset;
    }

    public void setLapset(DynaaminenTauluInterface lapset) {
        this.lapset = lapset;
    }

    public boolean isOnkoSana() {
        return onkoSana;
    }

    public void setOnkoSana(boolean onkoSana) {
        this.onkoSana = onkoSana;
    }

    public LinkedList getRivit() {
        return rivit;
    }

    public void setRivit(LinkedList rivit) {
        this.rivit = rivit;
    }
    
    public void lisääRivi(int rivi){
        rivit.add(rivi);
    }
    
}