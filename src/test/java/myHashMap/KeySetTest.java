package myHashMap;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
public class KeySetTest {

    @Test (expected = IllegalStateException.class)
    public void throwExceptionBecauseMapIsEmpty() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.keySet();
    }

    @Test
    public void existingKeyIsAddedToKeySet() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        for(String element: map.keySet()) {
            assertTrue(map.containsKey(element));
        }
    }

    @Test
    public void keySetDoesNotContainDuplicateKeysCheckedWithSize() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        Set<String> keySet = map.keySet();
        assertEquals(1, keySet.size());
    }

    @Test
    public void keySetContainsAllUniqueKeys() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Mufasa");
        map.put("Boar", "Pumba");
        int count = 0;
        for(String key: map.keySet()) {
            assertTrue(map.containsKey(key));
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    public void keySetContainsAllUniqueKeysFromResizedMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Mufasa");
        map.put("Lemur", "Timone");
        map.put("Dinosaur", "Rex");
        map.put("Dog", "God");
        map.put("Boar", "Pumba");
        map.put("Snake", "Kaa");
        map.put("Leopard", "Bagera");
        map.put("Tiger", "Sher Khan");
        map.put("Lion2", "Scar");
        map.put("Bird", "Zazu");
        map.put("Fox", "Robin");
        map.put("Lion3", "Simba");
        map.put("Shark", "Bruce");

        int count = 0;
        for(String key: map.keySet()) {
            if(map.containsKey(key)) {
                count++;
            }
        }
        assertEquals(count, map.size());
        assertEquals(map.keySet().size(), map.size());
    }
}
