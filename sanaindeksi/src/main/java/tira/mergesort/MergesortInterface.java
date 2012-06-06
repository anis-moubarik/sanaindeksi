/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tira.mergesort;

/**
 *
 * @param <G> 
 * @author moubarik
 */
public interface MergesortInterface<G> {
    /**
     * Otetaan geneerinen taulukko ja järjestetään se käyttäen MergeSorttia.
     * @param s
     */
    public void sort(G[] s, int lkm);
}
