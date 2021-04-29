package myHashMap;

import org.junit.Test;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
public class RemoveTest {

    @Test (expected = IllegalStateException.class)
    public void throwExceptionForTryingToRemoveFromEmptyMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.remove("Fish");
    }

    @Test (expected = NoSuchElementException.class)
    public void throwExceptionTryingToRemoveObjectNotInMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.remove("Lion");
    }

    @Test
    public void successfullyRemoveExistingElementCheckedUsingSize() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Boar", "Pumba");
        map.remove("Fish");
        assertEquals(1, map.size());
    }

    @Test
    public void successfullyRemoveExistingElementCheckedUsingContainsKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Boar", "Pumba");
        map.remove("Fish");
        assertFalse(map.containsKey("Fish"));
    }

    @Test (expected = IllegalStateException.class)
    public void removeElementFromMapAndThrowExceptionForCallingRemoveAgainOnEmptyMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.remove("Fish");
        map.remove("Lion");
    }

    @Test (expected = IllegalStateException.class)
    public void removeElementFromMapAndThrowExceptionForCallingGetOnEmptyMap() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.remove("Fish");
        map.get("Fish");

    }

    @Test
    public void removedKeyValuePairReturnsValueOfKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Lion", "Simba");
        assertEquals("Nemo", map.remove("Fish"));
    }

    @Test
    public void removedDuplicateKeyReturnsOverriddenValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("Fish", "Nemo");
        map.put("Fish", "Dory");
        assertEquals("Dory", map.remove("Fish"));
    }


}
