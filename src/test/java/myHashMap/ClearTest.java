package myHashMap;

import org.junit.Test;

import static org.junit.Assert.*;
public class ClearTest {

    @Test
    public void clearMapAndSizeReturnsZero() {
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

        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void clearedMapWontReturnAnyElementsPreviouslyInMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Mufasa");
        map.put("Lemur", "Timone");

        map.clear();

        map.put("needThisForTest", "EmptyMapThrowsException");

        assertFalse(map.containsKey("Fish"));
        assertFalse(map.containsKey("Lion"));
        assertFalse(map.containsKey("Lemur"));
    }

    @Test (expected = IllegalStateException.class)
    public void throwExceptionForSearchingClearedMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Mufasa");
        map.put("Lemur", "Timone");
        map.put("Dinosaur", "Rex");

        map.clear();

        map.containsKey("Lion");
    }


}
