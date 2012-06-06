package tira.dynaaminentaulu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tira.trie.TrieSolmu;





/**
 * 
 * @author Anis
 */
public class DynaaminenTaulu implements DynaaminenTauluInterface<TrieSolmu>{

    private ArrayList<TrieSolmu> al;
    private int count = 0;
    
    /**
     * 
     */
    public DynaaminenTaulu(){
        al = new ArrayList<TrieSolmu>();
    }
    
    /**
     * Lisätään TrieSolmu dynaamiseen tauluun.
     * @param o 
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
     * Palauttaa true, jos solmu löytyy taulusta
     * @param elem 
     * @return true
     */
    public boolean sisältää(TrieSolmu elem) {
        return al.contains(elem);
    }

    /**
     * Haetaan indeksillä solmua, jos indeksi on liian suuri tai pieni palautetaan null.
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
     * Palauttaa true, jos taulu on tyhjä
     * @return true
     */
    public boolean onkoTyhjä() {
        return al.isEmpty();
    }

    /**
     * Poistetaan indeksissä oleva solmu ja palautetaan se.
     * @param index 
     * @return TrieSolmu
     */
    public TrieSolmu poista(int index) {
        return al.remove(index);
    }
    
    /**
     * Palauttaa taulun koko
     * @return int
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
     * Etsitään kirjaimella solmu, palauttaa solmun tai nullin, jos sitä ei löydetä.
     * @param c 
     * @return  TrieSolmu
     */
    
    public TrieSolmu etsi(Object c){
        int index = binääriHaku((Character)c);
        return hae(index);
    }
    
    
    /**
     * Binäärihaku, haetaan kirjaimen ASCII koodilla taulukosta kyseinen kirjain.
     * palautetaan kirjaimen indeksi, tai -1 jos kirjainta ei löydy.
     * @param c
     * @return 
     */
    private int binääriHaku(char c){
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

    /**
     * 
     * @param o
     * @return
     */
    public Object[] toArray(Object[] o) {
        return al.toArray(o);
    }

}
class DtComparator implements Comparator{
    
    /**
     * Comparator luokka TrieSolmujen lapsien sorttaamista varten.
     * Käytetään kirjainten ASCII koodeja niitten järjestämiseen.
     * @param t1
     * @param t2
     * @return 
     */
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