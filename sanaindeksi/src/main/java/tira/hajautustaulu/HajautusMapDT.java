/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.hajautustaulu;

import java.util.*;
import java.util.Map.Entry;
import tira.dynaaminentaulu.DynaaminenTauluInt;
import tira.dynaaminentaulu.DynaaminenTauluInterface;


/**
 *
 * @author moubarik
 */
public class HajautusMapDT{

    private LinkedList<Map.Entry>[] taulukko;
    private LinkedList<Map.Entry> taulu = new LinkedList<Map.Entry>();
    private final double loadFactor = 0.8;
    private int koko;
    private int täyttö;
    
    public HajautusMapDT(int koko){
        taulukko = new LinkedList[koko];
        this.koko = koko;
    }
    
    public HajautusMapDT(){
        this(50);
    }
    
    public LinkedList<Map.Entry>[] getTaulukko(){
        return taulukko;
    }
    
    public void rehash(){
        LinkedList<Map.Entry>[] apu = taulukko;
        taulukko = new LinkedList[koko*2];
        koko = koko*2;
        for (int i = 0; i < apu.length; i++) {
            put((String)taulukko[i].get(i).getKey(), (DynaaminenTauluInt)taulukko[i].get(i).getValue());
            
        }
    }
    
    public void put(String tiedosto, DynaaminenTauluInterface<Integer> rivinumerot) {
        Map.Entry<String, DynaaminenTauluInterface<Integer>> entry = new TiedostoRiviNumeroEntry<String, DynaaminenTauluInterface<Integer>>(tiedosto, rivinumerot);
        int hash = hashCode(rivinumerot.hae(0).toString());
        taulu = taulukko[hash];
        if(taulu == null){
            taulu = new LinkedList();
            taulu.add(entry);
        }else{
            taulu.add(entry);
       }
       taulukko[hash] = taulu;
        
    }

    private boolean search(Entry<String, DynaaminenTauluInterface<Integer>> entry) {
        taulu = taulukko[hashCode(entry.getKey())];
        return listSearch(entry, taulu);
    }

    private boolean listSearch(Entry<String, DynaaminenTauluInterface<Integer>> entry, LinkedList<Entry> etsittäväTaulu) {
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

    public DynaaminenTauluInterface<Integer> get(String s) {
        int hc = hashCode(s);
        LinkedList<Map.Entry> löydetty = taulukko[hc];
        
        if(löydetty == null || löydetty.size() == 0)
            return null;
        
        for (int i = 0; i < löydetty.size(); i++) {
            if(löydetty.get(i).getKey().equals(s))
                return (DynaaminenTauluInt)löydetty.get(i).getValue();
        }
        return null;
        
    }
    
}
