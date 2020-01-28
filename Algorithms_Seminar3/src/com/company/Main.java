package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Timer timer = new Timer();
    static Scanner scanner = new Scanner(System.in);
    static Integer[] randomInt = new Integer[1000000];



    public static void main(String[] args) {
        try {
            Scanner fileScan = new Scanner(new File("Algorithms_Seminar3/src/randomnumbers.txt"));
            int i = 0;
            while (fileScan.hasNext()) {
                randomInt[i++] = fileScan.nextInt();
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mainMenu();
    }

    private static void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("1. Task 1");
            System.out.println("2. Task 2");
            System.out.println("3. Task 3");
            System.out.println("4. Task 4 (not done)");
            System.out.println("5. exit program");
            System.out.println("Task to check:");
            String task = scanner.nextLine();
            String subTask;
            switch (task) {
                case "1":
                    BinaryHeap binaryHeap = new BinaryHeap(2000000);
                    System.out.println("1. Initially empty heap");
                    System.out.println("2. Linear-time algorithm");
                    subTask = scanner.nextLine();
                    switch (subTask) {
                        case "1":
                            heapMenu(binaryHeap);
                            break;
                        case "2":
                            linearHeapMenu(binaryHeap);
                            break;
                    }
                    break;
                case "2":
                    hashMenu();
                    break;
                case "3":
                    timer.startTimer();
                    wordPuzzle();
                    timer.stopTimer();
                    System.out.println(timer.getTimeinSec());
                    break;
                case "4":
                    System.out.println("Task 4 not complete");
                    break;
                case "5":
                    running = false;
                    break;
            }
            scanner.nextLine();
        }
    }

    private static void linearHeapMenu(BinaryHeap binaryHeap) {
        boolean running = true;
        while (running) {
            int i;
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Print");
            System.out.println("4. Read");
            System.out.println("5. RandomNumbers");
            System.out.println("6. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": //Insert
                    System.out.println("Integer to insert:");
                    try {
                        i = scanner.nextInt();
                        scanner.nextLine();
                        timer.startTimer();
                        binaryHeap.insertLinearly(i);
                        timer.stopTimer();
                        System.out.println(timer.getTimeinSec());
                        System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                        System.out.println("Inserted: " + i);
                    } catch (InputMismatchException e) {
                        System.out.println("Not an integer");
                    }
                    break;
                case "2": //Remove
                    timer.startTimer();
                    System.out.println("Removed: " + binaryHeap.removeHead());
                    timer.stopTimer();
                    System.out.println(timer.getTimeinSec());
                    System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                    break;
                case "3"://Print
                    binaryHeap.sort();
                    binaryHeap.print();
                    System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                    break;
                case "4":

                    linearHeapMenu(binaryHeap);
                    break;
                case "5":
                    System.out.println("How many numbers?");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    timer.startTimer();
                    for (int j = 0; j < quantity; j++) {
                        binaryHeap.insertLinearly(randomInt[j]);
                    }
                    binaryHeap.sort();
                    timer.stopTimer();
                    System.out.println(timer.getTimeinSec());
                    break;
                case "6":
                    running = false;
                    mainMenu();
            }
        }
    }

    private static void heapMenu(BinaryHeap binaryHeap) {
        boolean running = true;
        while (running) {
            int i;
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Print");
            System.out.println("4. RandomNumbers");
            System.out.println("5. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": //Insert
                    System.out.println("Integer to insert:");
                    try {
                        i = scanner.nextInt();
                        scanner.nextLine();
                        timer.startTimer();
                        binaryHeap.insert(i);
                        timer.stopTimer();
                        System.out.println(timer.getTimeinSec());
                        System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                        System.out.println("Inserted: " + i);
                    } catch (InputMismatchException e) {
                        System.out.println("Not an integer");
                    }
                    break;
                case "2": //Remove
                    timer.startTimer();
                    System.out.println("Removed: " + binaryHeap.removeHead());
                    timer.stopTimer();
                    System.out.println(timer.getTimeinSec());
                    System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                    break;
                case "3":
                    binaryHeap.print();
                    System.out.println("Swaps: " + binaryHeap.getSwapCounter());
                    break;
                case "4":
                    System.out.println("How many numbers?");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    timer.startTimer();
                    for (int j = 0; j < quantity; j++) {
                        binaryHeap.insert(randomInt[j]);
                    }
                    binaryHeap.sort();
                    timer.stopTimer();
                    System.out.println(timer.getTimeinSec());
                    break;
                case "5":
                    running = false;
                    mainMenu();
            }
        }
    }

    private static void hashMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Double size? y/n");
            boolean duplicate = false;
            String dsize = scanner.nextLine();
            if (dsize.equals("y")) {
                duplicate = true;
            }
            System.out.println("1. Separate chaining hash table");
            System.out.println("2. Probing hash table");
            System.out.println("3. Separate chaining without UI and that works with Linked List");
            System.out.println("4. Exit");
            String subtask = scanner.nextLine();
            switch (subtask) {
                case "1":
                    Map<Integer, Integer> chain;
                    if (duplicate) {
                        chain = new Map<>(14, 7);
                    } else {
                        chain = new Map<>(7, 10);
                    }
                    chainMenu(chain, duplicate);
                    break;
                case "2":
                    LinearProbingHashTable linearProbingHashTable;
                    if (duplicate) {
                        linearProbingHashTable = new LinearProbingHashTable(14, 7);
                    } else {
                        linearProbingHashTable = new LinearProbingHashTable(7, 10);
                    }
                    probeMenu(linearProbingHashTable, duplicate);
                    break;
                case "3":
                    chained();
                    break;
                case "4":
                    running = false;
                    mainMenu();
            }
        }
    }

    private static void probeMenu(LinearProbingHashTable linearProbingHashTable, boolean duplicate) {
        boolean running = true;
        while (running) {
            int mod = 10;
            if (duplicate) {
                mod = 7;
            }
            int i;
            System.out.println("1. Insert with linear probing");
            System.out.println("2. Insert with quadratic probing");
            System.out.println("3. Get");
            System.out.println("4. Remove");
            System.out.println("5. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Integer to add linearly:");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    linearProbingHashTable.insertLinear(String.valueOf(i % mod % 7), String.valueOf(i));
                    break;
                case "2":
                    System.out.println("Integer to add quadraticly:");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    linearProbingHashTable.insertQuadratic(String.valueOf(i % mod % 7), String.valueOf(i));
                    break;
                case "3":
                    System.out.println("Key to get: ");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Got: " + linearProbingHashTable.get(String.valueOf(i)));
                    break;
                case "4":
                    System.out.println("Key to removeHead: ");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Removed: " + linearProbingHashTable.remove(String.valueOf(i)));
                    break;
                case "5":
                    running = false;
                    hashMenu();
                    break;
            }
        }
    }

    private static void chainMenu(Map<Integer, Integer> chain, boolean duplicate) {
        boolean running = true;
        while (running) {
            int mod = 10;
            if (duplicate) {
                mod = 7;
            }
            int i;
            System.out.println("1. Insert");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Integer to add:");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    chain.add(i % mod, i);
                    break;
                case "2":
                    System.out.println("Key to get: ");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Got: " + chain.get(i));
                    break;
                case "3":
                    System.out.println("Key to removeHead: ");
                    i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Removed: " + chain.remove(i));
                    break;
                case "4":
                    running = false;
                    hashMenu();
                    break;
            }
        }
    }

    private static void chained() {
        int[] inputs = {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        HashWithLinkedList hashWithLinkedList = new HashWithLinkedList(10);
        for (int input : inputs) {
            hashWithLinkedList.insert(input);
        }
        System.out.println("Seperate Chaining");
        hashWithLinkedList.print();
    }

    private static void wordPuzzle() {
        WordPuzzle wordPuzzle = new WordPuzzle();
        wordPuzzle.print();
        wordPuzzle.search();
    }
}
