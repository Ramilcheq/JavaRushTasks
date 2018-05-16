package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int result = 0;
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            result += entry.getValue().size();
        }
        return result;
    }

    @Override
    public V put(K key, V value) {
        //if (map.containsKey(key) && map.get(key) == null) return null;
        if (map.containsKey(key) && map.get(key) != null) {
            List listV = map.get(key);
            V last = (V) listV.get(listV.size() - 1);
            if (listV.size() == repeatCount) {
                listV.remove(0); //           ну тут хз может надо map.get(key).add?
            }
            listV.add(value);
            return last;
        } else {
            ArrayList<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        //return null;
    }

    @Override
    public V remove(Object key) {
        V result = null;
        if (map.containsKey(key)) {
            if (map.get(key).size() == 0) {
                map.remove(key);
            } else {
                result = map.get(key).get(0);
                map.get(key).remove(0);
                if (map.get(key).size()==0) map.remove(key);
            }
        }
        return result;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> result = new HashSet<>();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> result = new ArrayList<>();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            for (V v : entry.getValue()) {
                if (value.equals(v)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}