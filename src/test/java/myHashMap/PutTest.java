package myHashMap;

import org.junit.Test;

import static org.junit.Assert.*;
public class PutTest {

    @Test
    public void newKeyValuePairIsAddedToMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        assertEquals("Nemo", map.get("Fish"));
    }

    @Test
    public void duplicateKeyValueReplacesAndMapsToOriginalKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        assertEquals("Dory", map.get("Fish"));
    }

    @Test
    public void duplicateKeyDeletesOldKeySoListSizeDoesntChange() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        assertEquals(1, map.size());
    }
}
