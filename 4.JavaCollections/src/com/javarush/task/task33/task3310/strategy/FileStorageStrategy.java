package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private int size;
    long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();
            while (entry != null) {
                if (entry.value.equals(value))
                    return true;

                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        } else {
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();

            while (entry != null) {
                if (entry.value.equals(value))
                    return entry.key;
                entry = entry.next;
            }
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.value;

        return null;
    }
}
/*public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    long maxBucketSize;

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
        bucketSizeLimit = bucketSizeLimit + 4;
    }

    public void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j].getEntry();
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        if(table[bucketIndex] == null) table[bucketIndex] = new FileBucket();
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, table[bucketIndex].getEntry()));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return containsNullValue();
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) continue;
            for (Entry e = tab[i].getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    private boolean containsNullValue() {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i].getEntry(); e != null; e = e.next)
                if (e.value == null)
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash((long) key.hashCode());
        int i = indexFor(hash, table.length);
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i].getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return e.key;
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key) == null ? null: getEntry(key).value;
    }
}
*/