/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.mergesort;

/**
 *
 * @author moubarik
 */
public class MergesortInt implements MergesortInterface{

    @Override
    public void sort(Object[] s) {
        int [] tmp = new int[s.length];
        int[] luvut = {};
        int i = 0;
        for(Object o : s){
            luvut[i] = (Integer) o;
            i++;
        }
        mergesort(luvut, tmp, 0, s.length-1);
    }
    
    private void mergesort(int[] a, int[] tmp, int vas, int oik) {
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

    private void merge(int[] a, int[] tmp, int vasP, int oikP, int oikLoppu) {
        
        int vasLoppu = oikP -1;
        int tmpP = vasP;
        int elements = oikLoppu - vasP + 1;
        
        while(vasP <= vasLoppu && oikP <= oikLoppu)
        {
            if(a[vasP] < a[oikP])
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
        
        
        //
        for(int i = 0; i < elements; i++, oikLoppu--){
            a[oikLoppu] = tmp[oikLoppu];
        }
    }

    
}
