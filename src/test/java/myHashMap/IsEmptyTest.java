package myHashMap;

import org.junit.Test;

import static org.junit.Assert.*;
public class IsEmptyTest {

    @Test
    public void emptyMapReturnTrue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        assertTrue(map.isEmpty());
    }

    @Test
    public void mapDoesContainElementsReturnFalse() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertFalse(map.isEmpty());
    }

    @Test
    public void removeDuplicateKeyOfOnlyKeyValuePairAndMapIsEmpty() {
            MyHashMap<String, String> map = new MyHashMap<>();
            map.put("Fish", "Nemo");
            map.put("Fish", "Dory");
            map.remove("Fish");
            assertTrue(map.isEmpty());
    }

    @Test
    public void resizeMapThenCheckMapNotEmpty() {
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

        assertFalse(map.isEmpty());
    }
}