package tira.dynaaminentaulu;

import java.util.Arrays;
import tira.mergesort.MergesortInterface;
import tira.mergesort.MergesortTS;
import tira.trie.TrieSolmu;





/**
 * 
 * @author Anis
 */
public class DynaaminenTaulu implements DynaaminenTauluInterface<TrieSolmu>{

    private MergesortInterface<TrieSolmu> ms;
    
    
    private int lkm;
    private TrieSolmu alkiot[];
    
    /**
     * Luodaan 10 alkion kokoinen taulukko.
     */
    public DynaaminenTaulu(){
        this(5);     
    }
    
    /**
     * Luodaan parametrin kokoinen taulukko.
     * @param koko
     */
    public DynaaminenTaulu(int koko){
        lkm = 0;
        alkiot = new TrieSolmu[koko];
        ms = new MergesortTS();
    }
    
    /**
     * Lisätään TrieSolmu dynaamiseen tauluun.
     * @param o 
     */
    @Override
    public void lisää(TrieSolmu o) {
        if(lkm > alkiot.length - 1){
            TrieSolmu[] apu = alkiot;
            alkiot = new TrieSolmu[lkm*2];
            for (int i = 0; i < apu.length; i++) {
                alkiot[i] = apu[i];
            }
            alkiot[lkm] = o;
        }
        else
        {
            alkiot[lkm] = o;
        }
        lkm++;
        järjestäTaulu();
    }

    /**
     * Tyhjentää taulun.
     */
    @Override
    public void tyhjennäTaulu() {
        alkiot = new TrieSolmu[0];
        lkm = 0;
    }

    /**
     * Palauttaa true, jos solmu löytyy taulusta
     * @param elem 
     * @return true
     */
    @Override
    public boolean sisältää(TrieSolmu elem) {
        for(int i = 0; i < lkm; i++){
            if(elem.equals(alkiot[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * Haetaan indeksillä solmua, jos indeksi on liian suuri tai pieni palautetaan null.
     * @param index jolla taulusta haetaan solmu.
     * @return TrieSolmu joka on löydetty indexin kohdalta.
     */
    @Override
    public TrieSolmu hae(int index) {
        if(index > lkm)
            return null;
        else if(index < 0)
            return null;
        else
            return alkiot[index];
    }

    /**
     * Palauttaa true, jos taulu on tyhjä
     * @return true
     */
    @Override
    public boolean onkoTyhjä() {
        return (lkm == 0) ? true : false;
    }

    /**
     * Poistetaan indeksissä oleva solmu ja palautetaan se.
     * @param index 
     * @return TrieSolmu
     */
    @Override
    public TrieSolmu poista(int index) {
        TrieSolmu poistettava;
        if(index == lkm-1)
        {
            poistettava = alkiot[index];
            lkm--;
        }
        else
        {
            TrieSolmu seur = alkiot[index+1];
            poistettava = alkiot[index];
            alkiot[index] = seur;
            lkm--;
        }
        return poistettava;
    }
    
    /**
     * Palauttaa taulun koko
     * @return int
     */
    @Override
    public int size(){
        return lkm;
    }

    /**
     * Järjestetään taulu leksikografiseen järjestykseen.
     */
    @Override
    public void järjestäTaulu() {
        if(lkm > 1)
            ms.sort(alkiot, lkm);
    }
    
    /**
     * Etsitään kirjaimella solmu, palauttaa solmun tai nullin, jos sitä ei löydetä.
     * @param c 
     * @return  TrieSolmu
     */
    
    @Override
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
        end = lkm - 1;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(alkiot[mid].getKirjain() < c)
                start = mid + 1;
            else if (alkiot[mid].getKirjain() > c)
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
    @Override
    public Object[] toArray(Object[] o) {
        return alkiot;
    }

}