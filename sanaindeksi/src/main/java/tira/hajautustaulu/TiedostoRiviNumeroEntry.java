package tira.hajautustaulu;

import java.util.Map;



/**
 * 
 * @author Anis
 * @param <K>
 * @param <V>
 */
public final class TiedostoRiviNumeroEntry<K, V> implements Map.Entry<K, V>{
    
    private final K key;
    private V value;
    
    /**
     * Luodaan Key - Value objekti jolle annetaan parametrina objektit key ja value.
     * @param key
     * @param value
     */
    public TiedostoRiviNumeroEntry(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V vanha = this.value;
        this.value = value;
        return vanha;
    }

    
}