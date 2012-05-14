package tira.trie;

public class TrieSolmu{
    
    char kirjain;
    DynaaminenTauluInterface lapset;
    boolean onkoSana;
    
    public TrieSolmu(char kirjain, boolean onkoSana){
        this.kirjain = kirjain;
        this.onkoSana = onkoSana;
        this.lapset = new DynaaminenTaulu();
    }
    
}