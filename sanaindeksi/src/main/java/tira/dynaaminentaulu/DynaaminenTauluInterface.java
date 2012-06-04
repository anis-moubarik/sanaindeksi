
package tira.dynaaminentaulu;

/**
 * Geneerinen taulu rajapinta.
 * @author moubarik
 */
public interface DynaaminenTauluInterface<G> {
    /**
     * 
     * @param o
     */
    public void lisää(G o);
    /**
     * 
     */
    public void tyhjennäTaulu();
    /**
     * 
     * @param elem
     * @return
     */
    public boolean sisältää(G elem);
    /**
     * 
     * @param index
     * @return
     */
    public G hae(int index);
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
    public G poista(int index);
    /**
     * 
     * @return
     */
    public int size();
    /**
     * 
     */
    public void järjestäTaulu();
    
    public G etsi(Object i);
    
    public Object[] toArray(Object[] o);
}
