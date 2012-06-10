package tira.hajautustaulu;

import java.util.Map;



final class TiedostoRiviEntry<K, V> implements Map.Entry<K, V>{
    
    private final K key;
    private V value;
    
    public TiedostoRiviEntry(K key, V value){
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