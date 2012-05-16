
package tira.trie;

public interface DynaaminenTauluInterface {
    
    public void lisää(TrieSolmu o);
    public void tyhjennäTaulu();
    public boolean sisältää(TrieSolmu elem);
    public TrieSolmu hae(int index);
    public boolean onkoTyhjä();
    public TrieSolmu poista(int index);
    public int size();
    public void järjestäTaulu();
    public TrieSolmu etsi(char c);
}
