package ro.ulbs.paradigme.lab2.api;

import ro.ulbs.paradigme.lab2.doublechained.DoubleChainedList;
import ro.ulbs.paradigme.lab2.simplechained.SimpleChainedList;

public class Main {
    public static void main(String[] args) {
        SimpleChainedList simpleList = new SimpleChainedList();
        for (int i = 1; i <= 10; i++) {
            simpleList.addValue(i);
        }
        simpleList.removeNodeByValue(4);
        simpleList.removeNodeByValue(6);
        simpleList.removeNodeByValue(8);
        simpleList.removeNodeByValue(10);
        simpleList.listNodes();

        DoubleChainedList doubleList = new DoubleChainedList();
        for (int i = 1; i <= 10; i++) {
            doubleList.addValue(i);
        }
        doubleList.removeNodeByValue(1);
        doubleList.removeNodeByValue(2);
        doubleList.removeNodeByValue(3);
        doubleList.listNodes();
        System.out.println("Suma listei simplu inlantuite : " + simpleList.sum());
        System.out.println("Suma listei dublu inlantuite : " + doubleList.sum());
        System.out.println("Lista simplu inlantuite este ordonata crescator: " + simpleList.isSorted());
        System.out.println("Lista dublu inlantuite este ordonata crescator: " + doubleList.isSorted());
    }
}