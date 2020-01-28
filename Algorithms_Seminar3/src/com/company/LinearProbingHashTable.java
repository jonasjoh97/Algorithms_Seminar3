package com.company;

//based on: https://www.sanfoundry.com/java-program-implement-hash-tables-linear-probing/

class LinearProbingHashTable {
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;
    int mod;

    //Constructor
    public LinearProbingHashTable(int capacity, int mod) {
        this.mod = mod;
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    //Function to clear hash table

    public void makeEmpty() {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    // Function to get size of hash table

    public int getSize() {
        return currentSize;
    }


    //Function to check if hash table is full

    public boolean isFull() {
        return currentSize == maxSize;
    }

    //Function to check if hash table is empty

    public boolean isEmpty() {
        return getSize() == 0;
    }

    //Function to check if hash table contains a key
    public boolean contains(String key) {
        return get(key) != null;
    }

    //Function to get hash code of a given key
    private int hash(String key) {
        return key.hashCode() % mod;
    }

    //Function to insert key-value pair
    public void insertLinear(String key, String val) {
        int tmp = Integer.parseInt(key);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                System.out.println("Key: " + i);
                return;
            } else {
                i = (i + 1) % maxSize;
                key = String.valueOf(i);
            }

        } while (i != tmp);
        System.out.println("Could not add");
    }

    public void insertQuadratic(String key, String val) {
        int tmp = Integer.parseInt(key);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                System.out.println("Key: " + i);
                return;
            } else {
                i = (i * i) % maxSize;
                key = String.valueOf(i);
            }
        } while (i != tmp);
        System.out.println("Could not add");
    }

    //Function to get value for a given key
    public String get(String key) {
        int i = Integer.parseInt(key);
        while (keys[i] != null) {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }

    //Function to removeHead key and its value
    public String remove(String key) {
        if (!contains(key))
            return null;

        //find position key and delete
        int i = Integer.parseInt(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        String returnable = vals[i];
        keys[i] = vals[i] = null;

        //rehash all keys
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;
            insertLinear(tmp1, tmp2);
        }
        currentSize--;
        return returnable;
    }

    //Function to print HashTable
    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + vals[i]);
        System.out.println();
    }
}
