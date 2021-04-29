package myHashMap;

import org.junit.Test;
import static org.junit.Assert.*;


public class GetTest {

    @Test (expected = IllegalStateException.class)
    public void throwExceptionForSearchingEmptyMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.get("Fish");
    }

    @Test
    public void keyNotInMapReturnNull() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertNull(map.get("Lion"));
    }

    @Test
    public void keyIsInMapReturnValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertEquals("Nemo", map.get("Fish"));
    }

    @Test
    public void duplicateKeyOverridesValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        assertEquals("Dory", map.get("Fish"));
    }

    @Test
    public void mapResizedStillContainsOriginalKeyValuePairs() {
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

        assertEquals("Bruce", map.get("Shark"));
    }
}
