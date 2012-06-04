/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author moubarik
 */
public class Mergesort {
    
    private String[] järjestettävä;
    private String[] apu;
    private int lkm;
    
    public void sort(String[] s){
        this.järjestettävä = s;
        lkm = s.length;
        this.apu = new String[lkm];
        mergesort(0, lkm - 1);
    }

    private void mergesort(int ala, int ylä) {
        if(ala < ylä)
        {
            int mid = (ala + ylä) / 2;
            //Järjestetään vasen puoli
            mergesort(ala, mid);
            //Järjestetään oikea puoli
            mergesort(mid + 1, ylä);
            //Mergetään yhteen
            merge(ala, mid, ylä);
        }
    }

    private void merge(int ala, int mid, int ylä) {
        
        for (int i = ala; i <= ylä; i++) {
            apu[i] = järjestettävä[i];
        }
        
        int i = ala;
        int j = mid + 1;
        int k = ala;
        
        while(i <= mid && j <= ylä){
            if(apu[i].compareTo(apu[j]) <= 0){
                järjestettävä[k] = apu[i];
                i++;
            } else {
                järjestettävä[k] = apu[j];
                j++;
            }
        }
        
        while(i <= mid){
            järjestettävä[k] = apu[i];
            k++;
            i++;
        }
    }
}
