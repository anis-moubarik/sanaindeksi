/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.dynaaminentaulu;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author moubarik
 */
public class DynaaminenTauluString implements DynaaminenTauluInterface{
    
    private ArrayList<String> al = new ArrayList<String>();
    
    public void lisää(Object o) {
        al.add((String)o);
    }

    public void tyhjennäTaulu() {
        al.clear();
    }

    public boolean sisältää(Object elem) {
        return al.contains((String)elem);
    }

    public Object hae(int index) {
        return (String) al.get(index);
    }

    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    public Object poista(int index) {
        return (String) al.remove(index);
    }

    public int size() {
        return al.size();
    }

    public void järjestäTaulu() {
        Collections.sort(al);
    }

    public Object etsi(Object i) {
        int index = binääriHaku((String) i);
        return hae(index);
    }

    private int binääriHaku(String c) {
        int start, end, mid;
        start = 0;
        end = al.size() - 1;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(al.get(mid).compareTo(c) < 0)
                start = mid + 1;
            else if (al.get(mid).compareTo(c) > 0)
                end = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }

    public Object[] toArray(Object[] o) {
        return al.toArray(o);
    }
}

