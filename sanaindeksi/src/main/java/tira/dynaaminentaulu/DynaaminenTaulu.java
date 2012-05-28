package tira.dynaaminentaulu;

import java.util.*;
import tira.trie.TrieSolmu;


/**
 * 
 * @author Anis
 */
public class DynaaminenTaulu implements DynaaminenTauluInterface{

    private ArrayList<TrieSolmu> al;
    private int count = 0;
    
    /**
     * 
     */
    public DynaaminenTaulu(){
        al = new ArrayList<TrieSolmu>();
    }
    
    /**
     * 
     * @param Lisättävä TrieSolmu
     */
    public void lisää(TrieSolmu o) {
        al.add(o);
        järjestäTaulu();
    }

    /**
     * Tyhjentää taulun.
     */
    public void tyhjennäTaulu() {
        al.clear();
    }

    /**
     * 
     * @param haettava TrieSolmu
     * @return true jos TrieSolmu löytyy dynaamisestataulusta.
     */
    public boolean sisältää(TrieSolmu elem) {
        return al.contains(elem);
    }

    /**
     * 
     * @param index jolla taulusta haetaan solmu.
     * @return TrieSolmu joka on löydetty indexin kohdalta.
     */
    public TrieSolmu hae(int index) {
        if(index > al.size())
            return null;
        else if(index < 0)
            return null;
        else
            return al.get(index);
    }

    /**
     * 
     * @return true jos taulu on tyhjä
     */
    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    /**
     * 
     * @param index poistettava solmu
     * @return TrieSolmu joka on poistettu
     */
    public TrieSolmu poista(int index) {
        return al.remove(index);
    }
    
    /**
     * 
     * @return taulun koko
     */
    public int size(){
        return al.size();
    }

    /**
     * Järjestetään taulu leksikografiseen järjestykseen.
     */
    public void järjestäTaulu() {
        Collections.sort(al, new DtComparator());
    }
    
    /**
     * 
     * @param etsittävä kirjain solmutaulusta.
     * @return löydetty TrieSolmu, tai jos kirjainta ei löydetä, null
     */
    public TrieSolmu etsi(char c){
        int index = bSearch(c);
        return hae(index);
    }

    private int bSearch(char c){
        int start, end, mid;
        start = 0;
        end = al.size() - 1;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(al.get(mid).getKirjain() < c)
                start = mid + 1;
            else if (al.get(mid).getKirjain() > c)
                end = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }
    
}

class DtComparator implements Comparator{

    public int compare(Object t1, Object t2) {
        char c1 = ((TrieSolmu)t1).getKirjain();
        char c2 = ((TrieSolmu)t2).getKirjain();
        if(c1 > c2)
            return 1;
        else if(c1 < c2)
            return -1;
        else
            return 0;    }
    
}