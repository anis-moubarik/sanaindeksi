
package tira.hajautustaulu;

/**
 *
 * @author moubarik
 */
public class HajautusMap {

    private TiedostoRiviEntry[] taulu;
    private int koko;
    private final double loadFactor = 0.8;
    private int täyttö;

    /**
     * 
     * @param koko
     */
    public HajautusMap(int koko) {
        taulu = new TiedostoRiviEntry[koko];
        this.koko = koko;
    }

    /**
     * 
     */
    public HajautusMap() {
        this(10);
    }
    
    /**
     * 
     * @return
     */
    public TiedostoRiviEntry[] getTaulukko(){
        return taulu;
    }

    private void rehash() {
        TiedostoRiviEntry[] apu = taulu;
        taulu = new TiedostoRiviEntry[koko*2];
        koko = koko*2;
        for (int i = 0; i < apu.length; i++) {
            if(apu[i] == null)
                continue;
            put((String)apu[i].getKey(), (String[])apu[i].getValue());
        }
    }
    
    /**
     * 
     * @param tiedosto
     * @param sanat
     */
    public void put(String tiedosto, String[] sanat) {
        int hash = (mjToInt(tiedosto) % koko);

        while (taulu[hash] != null && taulu[hash].getKey() != tiedosto) {
            hash = (hash + 1) % koko;
        }
        taulu[hash] = new TiedostoRiviEntry(tiedosto, sanat);
        täyttö++;
        
        if(loadFactor < (täyttö / koko))
            rehash();
    }

    /**
     * 
     * @param key
     * @return
     */
    public String[] get(String key) {
        int hash = (mjToInt(key) % koko);
        while(taulu[hash] != null && !taulu[hash].getKey().equals(key))
            hash = (hash + 1) % koko;
        if(taulu[hash] == null)
            return null;
        else
            return (String[])taulu[hash].getValue();
    }

    private int mjToInt(String s) {
        char[] c = s.toCharArray();
        if(c.length <= 0)
            return 0;
        int summa = ascii(c[0]) + 128;

        if (c.length >= 3) {
            for (int i = 1; i < 3; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);

            }
        } else {
            for (int i = 0; i < c.length; i++) {
                summa *= ascii(c[i]) + Math.pow(128, i);

            }
        }

        return summa;
    }

    private int ascii(char c) {
        return c - 64;
    }

}
