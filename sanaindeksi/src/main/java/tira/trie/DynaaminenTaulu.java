package tira.trie;

import java.util.ArrayList;

public class DynaaminenTaulu implements DynaaminenTauluInterface{

    private ArrayList<TrieSolmu> al;
    
    public DynaaminenTaulu(){
        al = new ArrayList<TrieSolmu>();
    }
    
    public void lisää(TrieSolmu o) {
        al.add(o);
    }

    public void tyhjennäTaulu() {
        al.clear();
    }

    public boolean sisältää(TrieSolmu elem) {
        return al.contains(elem);
    }

    public TrieSolmu hae(int index) {
        return al.get(index);
    }

    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    public TrieSolmu poista(int index) {
        return al.remove(index);
    }
    
    
}