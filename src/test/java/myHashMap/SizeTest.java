package myHashMap;

import org.junit.Test;
import static org.junit.Assert.*;

public class SizeTest {

    @Test
    public void mapIsEmptyReturnZero() {
        MyHashMap<String, String> map = new MyHashMap<>();
        assertEquals(0, map.size());
    }

    @Test
    public void sizeIncreasesByOneWhenAddingNewKeyValuePair() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertEquals(1, map.size());
    }

    @Test
    public void duplicateKeyOverridesOriginalAndSizeDoesNotIncreaseOrDecrease() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        assertEquals(1, map.size());
    }

    @Test
    public void sizeDecreasesByOneWhenExistingElementIsRemovedFromMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lemur", "Timone");
        map.remove("Fish");
        assertEquals(1, map.size());
    }
}
