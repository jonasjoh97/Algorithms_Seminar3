package com.company;

import java.util.LinkedList;


public class HashWithLinkedList {
    private LinkedList<Integer>[] array;

    public HashWithLinkedList(int size) {
        array = new LinkedList[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public int hash(int value) {
        return value % array.length;
    }


    public void insert(int value) {
        int key = hash(value);
        array[key].add(value);
    }


    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + ":\t");
            for (Integer integer : array[i]) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }
}

