package ro.ulbs.paradigme.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numere {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> numbers = r.ints(10,5,25).boxed().toList();;
      int s=  numbers.stream().mapToInt(n -> n).sum();
        System.out.println(numbers);
        System.out.println("Suma "+s);
        int max = numbers.stream().max(Integer::compare).get();
        System.out.println("Maximul este " + max);
    int min = numbers.stream().min(Integer::compare).get();
    System.out.println("Minimul este " + min);

    }
}
