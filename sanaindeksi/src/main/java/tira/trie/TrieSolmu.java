package tira.trie;

import tira.dynaaminentaulu.DynaaminenTaulu;
import tira.dynaaminentaulu.DynaaminenTauluInterface;

public class TrieSolmu{
    
    char kirjain;
    DynaaminenTauluInterface lapset;
    boolean onkoSana;
    int[] rivit;
    
    public TrieSolmu(char kirjain, boolean onkoSana, int[] rivit){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
        this.rivit = rivit;
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

    public int[] getRivit() {
        return rivit;
    }

    public void setRivit(int[] rivit) {
        this.rivit = rivit;
    }
    
}