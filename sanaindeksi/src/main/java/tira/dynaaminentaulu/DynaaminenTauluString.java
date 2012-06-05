/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.dynaaminentaulu;

import java.util.Arrays;
import tira.mergesort.Mergesort;
import tira.mergesort.MergesortInterface;

/**
 *
 * @author moubarik
 */
public class DynaaminenTauluString implements DynaaminenTauluInterface{
    
    //private ArrayList<String> al = new ArrayList<String>();
    
    private MergesortInterface ms;
    
    private int lkm;
    private String alkiot[];
    
    public DynaaminenTauluString(int koko){
        lkm = 0;
        alkiot = new String[koko];
        ms = new Mergesort();
    }
    
    public DynaaminenTauluString(){
        lkm = 0;
        alkiot = new String[50];
    }
    
    @Override
    public void lisää(Object o) {
        if(lkm > alkiot.length-1)
        {
            String[] apu = alkiot;
            //alkiot = new String[lkm*2];
            alkiot = Arrays.copyOf(apu, lkm*2);
            alkiot[lkm] = (String) o;
        }
        else
        {
        alkiot[lkm] = (String) o;
        }
        lkm++;
    }

    @Override
    public void tyhjennäTaulu() {
        alkiot = new String[0];
    }

    @Override
    public boolean sisältää(Object elem) {
        for (int i = 0; i < lkm; i++) {
            if(alkiot[i].equals((String)elem))
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
        String poistettava;
        if(index == lkm-1)
        {
            poistettava = alkiot[index];
            lkm--;
        }
        else
        {
            String seur = alkiot[index+1];
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
        //Collections.sort(al);
        ms.sort(alkiot);
    }

    @Override
    public Object etsi(Object i) {
        int index = binääriHaku((String) i);
        return hae(index);
    }

    private int binääriHaku(String c) {
        int start, end, mid;
        start = 0;
        end = alkiot.length - 1;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(alkiot[mid].compareTo(c) < 0)
                start = mid + 1;
            else if (alkiot[mid].compareTo(c) > 0)
                end = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }

    @Override
    public Object[] toArray(Object[] o) {
        return Arrays.copyOfRange(alkiot, 0, lkm);
    }
}

