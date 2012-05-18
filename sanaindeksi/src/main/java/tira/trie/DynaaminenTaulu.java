package tira.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Anis
 */
public class DynaaminenTaulu implements DynaaminenTauluInterface{

    private ArrayList<TrieSolmu> al;
    
    /**
     * 
     */
    public DynaaminenTaulu(){
        al = new ArrayList<TrieSolmu>();
    }
    
    /**
     * 
     * @param o
     */
    public void lisää(TrieSolmu o) {
        al.add(o);
        järjestäTaulu();
    }

    /**
     * 
     */
    public void tyhjennäTaulu() {
        al.clear();
    }

    /**
     * 
     * @param elem
     * @return boolean
     */
    public boolean sisältää(TrieSolmu elem) {
        return al.contains(elem);
    }

    /**
     * 
     * @param index
     * @return TrieSolmu
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
     * @return
     */
    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    /**
     * 
     * @param index
     * @return
     */
    public TrieSolmu poista(int index) {
        return al.remove(index);
    }
    
    /**
     * 
     * @return
     */
    public int size(){
        return al.size();
    }

    /**
     * 
     */
    public void järjestäTaulu() {
        Collections.sort(al, new DtComparator());
    }
    
    /**
     * 
     * @param c
     * @return
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
            
            if(al.get(mid).kirjain < c)
                start = mid + 1;
            else if (al.get(mid).kirjain > c)
                end = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }
    
}

class DtComparator implements Comparator{

    public int compare(Object t1, Object t2) {
        char c1 = ((TrieSolmu)t1).kirjain;
        char c2 = ((TrieSolmu)t2).kirjain;
        if(c1 > c2)
            return 1;
        else if(c1 < c2)
            return -1;
        else
            return 0;    }
    
}