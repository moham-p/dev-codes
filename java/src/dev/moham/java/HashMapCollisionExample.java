package dev.moham.java;


import java.util.HashMap;

public class HashMapCollisionExample {
    public static void main(String[] args) {

        var map = new HashMap<KeyWithSameHash, String>();
        map.put(new KeyWithSameHash("Key1"), "Value1");
        map.put(new KeyWithSameHash("Key2"), "Value2");
        map.put(new KeyWithSameHash("Key3"), "Value3");

        System.out.println(map.get(new KeyWithSameHash("Key3")));
    }
}

class KeyWithSameHash {
    private String key;

    public KeyWithSameHash(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 1001; // Causes all keys to hash to the same bucket
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KeyWithSameHash other = (KeyWithSameHash) obj;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return key;
    }
}