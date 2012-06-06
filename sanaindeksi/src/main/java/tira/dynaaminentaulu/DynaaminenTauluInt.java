/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.dynaaminentaulu;

import java.util.Arrays;
import tira.mergesort.MergesortInt;
import tira.mergesort.MergesortInterface;

/**
 *
 * @author moubarik
 */
public class DynaaminenTauluInt implements DynaaminenTauluInterface{

    private int lkm;
    private Integer[] alkiot;
    private MergesortInterface<Integer> ms;
    
    /**
     * Alustetaan taulu parametrin kokoiseksi.
     * @param koko
     */
    public DynaaminenTauluInt(int koko){
        lkm = 0;
        alkiot = new Integer[koko];
        ms = new MergesortInt();
    }
    
    /**
     * Ilman parametreja alustetaan taulu 50 alkion kokoiseksi.
     */
    public DynaaminenTauluInt(){
        lkm = 0;
        alkiot = new Integer[50];
    }
    
    @Override
    public void lisää(Object o) {
        if(lkm > alkiot.length-1)
        {
            Integer[] apu = alkiot;
            //alkiot = new String[lkm*2];
            alkiot = Arrays.copyOf(apu, lkm*2);
            alkiot[lkm] = (Integer) o;
        }
        else
        {
            alkiot[lkm] = (Integer) o;
        }
        lkm++;
    }

    @Override
    public void tyhjennäTaulu() {
        alkiot = new Integer[0];
    }

    @Override
    public boolean sisältää(Object elem) {
        for (int i = 0; i < lkm; i++) {
            if(alkiot[i] == (Integer) elem)
                return true;
        }
        return false;
    }

    @Override
    public Object hae(int index) {
        return alkiot[index];
    }

    @Override
    public boolean onkoTyhjä() {
        return (lkm == 0) ? true : false;
    }

    @Override
    public Object poista(int index) {
        int poistettava;
        if(index == lkm-1)
        {
            poistettava = alkiot[index];
            lkm--;
        }
        else
        {
            int seur = alkiot[index+1];
            poistettava = alkiot[index];
            alkiot[index] = seur;
            lkm--;
        }
        return poistettava;
    }

    @Override
    public int size() {
        return lkm;
    }

    @Override
    public void järjestäTaulu() {
        ms.sort(alkiot);
    }

    /**
     * 
     * @param i
     * @return
     */
    @Override
    public Object etsi(Object i) {
        int index = binääriHaku((Integer) i);
        return hae(index);
    }

    /**
     * 
     * @param o
     * @return
     */
    @Override
    public Object[] toArray(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private int binääriHaku(Integer c) {
                int start, end, mid;
        start = 0;
        end = alkiot.length - 1;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(alkiot[mid] < c)
                start = mid + 1;
            else if (alkiot[mid] > c)
                end = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }
    
}
