package util;

import java.util.*;

public class SetMap<K> implements Iterable<K> {

    private final HashMap<K, Integer> mapSet;

    public SetMap() {
        this.mapSet = new HashMap<>();
    }

    public void put(K key) {
        if(mapSet.containsKey(key)) {
            mapSet.replace(key, get(key) + 1);
        } else {
            mapSet.put(key, 1);
        }
    }

    public Integer get(K key) {
        return mapSet.get(key);
    }

    @Override
    public Iterator<K> iterator() {
        List<K> list = keyList();
        list.sort((a, b) -> get(b).compareTo(get(a)));
        return list.iterator();
    }

    public Set<K> keySet() {
        return mapSet.keySet();
    }

    public List<K> keyList() {
        return new ArrayList<>(keySet());
    }

    public Collection<Integer> values() {
        return mapSet.values();
    }

    public List<K> sortedList() {
        List<K> list = keyList();
        list.sort((a, b) -> get(b).compareTo(get(a)));
        return list;
    }

    public void clear() {
        mapSet.clear();
    }

    public int size() {
        return mapSet.size();
    }

    public boolean isEmpty() {
        return mapSet.isEmpty();
    }
}
