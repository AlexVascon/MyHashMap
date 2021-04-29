package myHashMap;

import org.junit.Test;

import static org.junit.Assert.*;
public class ResizeTest {

    @Test
    public void mapSizeIncreasesTwiceAndNoExceptionIsThrownBecauseIndexHasIncreased() {
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
        // Doubles
        map.put("Fisho", "Nemo");
        map.put("Liono", "Mufasa");
        map.put("Lemuro", "Timone");
        map.put("Dinosauro", "Rex");
        map.put("Dogo", "God");
        map.put("Boaro", "Pumba");
        map.put("Snakeo", "Kaa");
        map.put("Leopardo", "Bagera");
        map.put("Tigero", "Sher Khan");
        map.put("Lion2o", "Scar");
        map.put("Birdo", "Zazu");
        map.put("Foxo", "Robin");
        map.put("Lion3o", "Simba");
        map.put("Sharko", "Bruce");
        // Doubles again
        map.put("Fis", "Nemo");
        map.put("Lio", "Mufasa");
        map.put("Lemu", "Timone");
        map.put("Dinosau", "Rex");
        map.put("Do", "God");
        map.put("Boa", "Pumba");
        map.put("Snak", "Kaa");
        map.put("Leopar", "Bagera");
        map.put("Tige", "Sher Khan");
        map.put("Lio", "Scar");
        map.put("Bir", "Zazu");
        map.put("Fo", "Robin");
        map.put("Lio", "Simba");
        map.put("Shar", "Bruce");
    }

    @Test
    public void mapSizeShrinks() {
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

        map.put("Fisho", "Nemo");
        map.put("Liono", "Mufasa");
        map.put("Lemuro", "Timone");
        map.put("Dinosauro", "Rex");
        map.put("Dogo", "God");
        map.put("Boaro", "Pumba");
        map.put("Snakeo", "Kaa");
        map.put("Leopardo", "Bagera");
        map.put("Tigero", "Sher Khan");
        map.put("Lion2o", "Scar");
        map.put("Birdo", "Zazu");
        map.put("Foxo", "Robin");
        map.put("Lion3o", "Simba");
        map.put("Sharko", "Bruce");

        map.put("Fis", "Nemo");
        map.put("Lio", "Mufasa");
        map.put("Lemu", "Timone");
        map.put("Dinosau", "Rex");
        map.put("Do", "God");
        map.put("Boa", "Pumba");
        map.put("Snak", "Kaa");
        map.put("Leopar", "Bagera");
        map.put("Tige", "Sher Khan");
        map.put("Lio", "Scar");
        map.put("Bir", "Zazu");
        map.put("Fo", "Robin");
        map.put("Lio", "Simba");
        map.put("Shar", "Bruce");

        map.remove("Fish");
        map.remove("Lio");
        map.remove("Lemu");
        map.remove("Dinosau");
        map.remove("Do");
        map.remove("Boa");
        map.remove("Snak");
        map.remove("Leopar");

    }
}
