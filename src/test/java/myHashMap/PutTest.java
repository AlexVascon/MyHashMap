package myHashMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
    
    @Test
    public void putManyObjectsShouldSizeProperly() {
        MyHashMap<String, String> map = new MyHashMap<>();
        int size = 500000;
        int keyLength = 20;
        ThreadLocalRandom randGenerator = ThreadLocalRandom.current();
        Set<String> keySet = new HashSet<>(650);
        StringBuilder builder = new StringBuilder(10);
        while(size > keySet.size()){
            for(int i = 0; i < keyLength; i++) {
                int rand = randGenerator.nextInt(52);
                char base = (rand < 26) ? 'A' : 'a';
                char character = (char) (base + rand % 26);
                builder.append(character);
            }
            keySet.add(builder.toString());
            builder.setLength(0);
        }
        List<String> keyList = new ArrayList<>(keySet);
        for(String key : keyList){
            map.put(key, "TestValue");
        }
        assertEquals(size, map.size());
    }
}
