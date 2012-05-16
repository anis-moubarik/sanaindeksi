package tira.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DynaaminenTaulu implements DynaaminenTauluInterface{

    private ArrayList<TrieSolmu> al;
    
    public DynaaminenTaulu(){
        al = new ArrayList<TrieSolmu>();
    }
    
    public void lisää(TrieSolmu o) {
        al.add(o);
        järjestäTaulu();
    }

    public void tyhjennäTaulu() {
        al.clear();
    }

    public boolean sisältää(TrieSolmu elem) {
        return al.contains(elem);
    }

    public TrieSolmu hae(int index) {
        if(index > al.size())
            return null;
        else if(index < al.size())
            return null;
        else
            return al.get(index);
    }

    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    public TrieSolmu poista(int index) {
        return al.remove(index);
    }
    
    public int size(){
        return al.size();
    }

    public void järjestäTaulu() {
        Collections.sort(al, new DtComparator());
    }
    
    public TrieSolmu etsi(char c){
        int index = Collections.binarySearch((ArrayList)al, (int)c);
        return hae(index);
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