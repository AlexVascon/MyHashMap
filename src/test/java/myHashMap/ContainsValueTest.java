package myHashMap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class ContainsValueTest {

    @Test (expected = IllegalStateException.class)
    public void mapIsEmptySoThrowException() {
        MyHashMap<String, String> map = new MyHashMap<>();
        assertFalse(map.containsValue("Nemo"));
    }

    @Test
    public void singleElementIsInListSoContainsIsTrue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertTrue(map.containsValue("Nemo"));
    }

    @Test
    public void elementExistsWithinARangeOfNodes() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Bear", "Balu");
        map.put("Lion", "Mufasa");
        assertTrue(map.containsValue("Balu"));
        assertTrue(map.containsValue("Mufasa"));
        assertTrue(map.containsValue("Nemo"));
    }

    @Test
    public void deleteElementWithinRangeOfElementsAndContainsEqualsFalse() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Bear", "Balu");
        map.put("Lion", "Mufasa");
        map.remove("Bear");
        assertFalse(map.containsValue("Balu"));
    }

    @Test
    public void resizeMapAndKeyValuePairsCarryOverSoReturnTrue() {
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

        assertTrue(map.containsValue("Bruce"));
    }
}
