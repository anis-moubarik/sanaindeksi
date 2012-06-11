/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.hajautustaulu;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @author moubarik
 */
public class HajautusMap{

    private LinkedList<Map.Entry>[] taulukko;
    private LinkedList<Map.Entry> taulu = new LinkedList<Map.Entry>();
    private final double loadFactor = 0.8;
    private int koko;
    private int täyttö;
    
    public HajautusMap(int koko){
        taulukko = new LinkedList[koko];
        this.koko = koko;
    }
    
    public HajautusMap(){
        this(500);
    }
    
    public void rehash(){
        
    }
    
    public void put(String tiedosto, String[] rivit) {
        Map.Entry<String, String[]> entry = new TiedostoRiviEntry<String, String[]>(tiedosto, rivit);
        int hash = hashCode(entry.getKey());
        while(search(entry) == false){
            if(taulu == null){
                taulu = new LinkedList();
                taulu.add(entry);
                täyttö++;
            }else{
                taulu.add(entry);
            }
            taulukko[hash] = taulu;
        }
        
        if(loadFactor < (täyttö / koko))
            rehash();
        
    }

    private boolean search(Entry<String, String[]> entry) {
        taulu = taulukko[hashCode(entry.getKey())];
        return listSearch(entry, taulu);
    }

    private boolean listSearch(Entry<String, String[]> entry, LinkedList<Entry> etsittäväTaulu) {
        if(etsittäväTaulu == null){
            return false;
        }
        
        Entry eka = etsittäväTaulu.getFirst();
        for (int i = 0; i < etsittäväTaulu.size(); i++) {
            if(!eka.equals(entry) && taulu.get(i) != null){
                eka = taulu.get(i);
            } else {
                return true;
            }
            
        }
        return false;
    }

    private int hashCode(String entry) {
        int k = strToInt(entry);
        
        double fr = 0.6180339887 * k;
        int kokos = (int) fr;
        double hashCode = taulukko.length * (fr - (double)kokos);
        
        return (int)Math.abs(hashCode);
    }

    private int strToInt(String key) {
        char[] c = key.toCharArray();
        int summa = ascii(c[0]) + 128;
        
        if(c.length >= 3){
            for (int i = 1; i < 3; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);
            }
        }else{
            for (int i = 0; i < c.length; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);
                
            }
        }
        return summa;
    }

    private int ascii(char c) {
        return c-64;
    }

    public String[] get(String s) {
        int hc = hashCode(s);
        LinkedList<Map.Entry> löydetty = taulukko[hc];
        
        if(löydetty.size() == 0)
            return null;
        
        for (int i = 0; i < löydetty.size(); i++) {
            if(löydetty.get(i).getKey().equals(s))
                return (String[])löydetty.get(i).getValue();
        }
        return null;
        
    }
    
}
