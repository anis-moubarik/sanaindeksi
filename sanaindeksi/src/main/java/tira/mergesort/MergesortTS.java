/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.mergesort;

import java.util.Arrays;
import tira.trie.TrieSolmu;

/**
 *
 * @author moubarik
 */
public class MergesortTS implements MergesortInterface<TrieSolmu>{

    @Override
    public void sort(TrieSolmu[] s, int lkm) {
        //s = Arrays.copyOf(s, lkm);
        TrieSolmu[] tmp = new TrieSolmu[s.length];
        mergesort(s, tmp, 0, lkm-1);    
    }

    private void mergesort(TrieSolmu[] a, TrieSolmu[] tmp, int vas, int oik) {
        if(vas < oik)
        {
            int mid = (vas + oik) / 2;
            //Järjestetään vasen puoli
            mergesort(a, tmp, vas, mid);
            //Järjestetään oikea puoli
            mergesort(a, tmp, mid + 1, oik);
            //Mergetään
            merge(a, tmp, vas, mid+1, oik);
        }
    }

    private void merge(TrieSolmu[] a, TrieSolmu[] tmp, int vasP, int oikP, int oikLoppu) {
        int vasLoppu = oikP -1;
        int tmpP = vasP;
        int elements = oikLoppu - vasP + 1;
        
        while(vasP <= vasLoppu && oikP <= oikLoppu)
        {
            if(a[vasP].getKirjain() < a[oikP].getKirjain())
                tmp[tmpP++] = a[vasP++];
            else
                tmp[tmpP++] = a[oikP++];
        }
        
        while(vasP <= vasLoppu){
            tmp[tmpP++] = a[vasP++];
        }
        
        while(oikP <= oikLoppu){
            tmp[tmpP++] = a[oikP++];
        }
        
        for(int i = 0; i < elements; i++, oikLoppu--){
            a[oikLoppu] = tmp[oikLoppu];
        }    
    }
    
}
