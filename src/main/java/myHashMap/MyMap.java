package myHashMap;

import java.util.Set;

public interface MyMap<K, V> {
    boolean containsKey(Object key);

    boolean containsValue(Object value);

    boolean equals(Object o);

    int hashCode();

    V get(Object key);

    boolean isEmpty();

    Set<K> keySet();

    int size();

    Set<V> valueSet();

    V put(K key, V value);

    void remove(Object key);

}
