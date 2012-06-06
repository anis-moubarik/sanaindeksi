
package tira.dynaaminentaulu;

/**
 * Geneerinen taulu rajapinta.
 * @param <G> 
 * @author moubarik
 */
public interface DynaaminenTauluInterface<G> {
    /**
     * Lisää tauluun geneerinen olio o.
     * @param o
     */
    public void lisää(G o);
    /**
     * Tyhjentää taulu.
     */
    public void tyhjennäTaulu();
    /**
     * Tarkistaa löytyykö taulusta objekti elem.
     * @param elem
     * @return
     */
    public boolean sisältää(G elem);
    /**
     * Haetaan taulusta indeksin perusteella objekti.
     * @param index
     * @return
     */
    public G hae(int index);
    /**
     * Tarkistaa onko taulu tyhjä.
     * @return
     */
    public boolean onkoTyhjä();
    /**
     * Poistaa indeksin kohdalta objektin.
     * @param index
     * @return
     */
    public G poista(int index);
    /**
     * Palauttaa taulun koon.
     * @return
     */
    public int size();
    /**
     * Järjestää taulun.
     */
    public void järjestäTaulu();
    
    /**
     * Etsii taulusta objektia i.
     * @param i
     * @return
     */
    public G etsi(Object i);
    
    /**
     * Palautetaan dynaaminen taulu taulukkona.
     * @param o
     * @return
     */
    public Object[] toArray(Object[] o);
}
