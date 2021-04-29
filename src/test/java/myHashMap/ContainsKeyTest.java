package myHashMap;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class ContainsKeyTest {

    @Test(expected = IllegalStateException.class)
    public void throwExceptionForCheckingEmptyList() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.containsKey("Fish");
    }

    @Test
    public void returnFalseAsElementDoesNotExistInMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertFalse(map.containsKey("Lion"));
    }

    @Test
    public void returnTrueAsKeyIsInMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertTrue(map.containsKey("Fish"));
    }

    @Test
    public void returnFalseAsElementRemovedFromMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Scar");
        map.remove("Fish");
        assertFalse(map.containsKey("Fish"));
    }

    @Test
    public void returnTrueMapResizedAndElementPassedOver() {
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

        assertTrue(map.containsKey("Bird"));
    }
}
