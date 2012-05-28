
package tira.dynaaminentaulu;

import tira.trie.TrieSolmu;

/**
 * 
 * @author moubarik
 */
public interface DynaaminenTauluInterface {
    /**
     * 
     * @param o
     */
    public void lisää(TrieSolmu o);
    /**
     * 
     */
    public void tyhjennäTaulu();
    /**
     * 
     * @param elem
     * @return
     */
    public boolean sisältää(TrieSolmu elem);
    /**
     * 
     * @param index
     * @return
     */
    public TrieSolmu hae(int index);
    /**
     * 
     * @return
     */
    public boolean onkoTyhjä();
    /**
     * 
     * @param index
     * @return
     */
    public TrieSolmu poista(int index);
    /**
     * 
     * @return
     */
    public int size();
    /**
     * 
     */
    public void järjestäTaulu();
    /**
     * 
     * @param c
     * @return
     */
    public TrieSolmu etsi(char c);
}
