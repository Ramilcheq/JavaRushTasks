package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    //constructors

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.ceil(collection.size() / .75f));
        this.map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        oos.writeInt(map.size());
        for (E e : map.keySet()) {
            oos.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size = ois.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for(int i=0;i<size;i++){
            map.put((E) ois.readObject(), PRESENT);
        }
    }

    @Override
    public boolean add(Object o) {
        return null == map.put((E) o, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet as = new AmigoSet();
            as.map = (HashMap) map.clone();
            return as;
        } catch (Exception e) {
            throw new InternalError();
        }

    }
}
