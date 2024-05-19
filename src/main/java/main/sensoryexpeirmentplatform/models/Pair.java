package main.sensoryexpeirmentplatform.models;

class Pair<K, Integer> {
    private final K key;
    private final Integer value;

    public Pair(K key, Integer value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public String toString(){
        return key.toString();
    }
}
