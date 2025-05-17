package ro.ulbs.paradigme.lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Numere {
    public static void main(String[] args) {
        //9.3.1
        Random r = new Random();
        List<Integer> numbers = r.ints(10,5,25).boxed().toList();;
      int s=  numbers.stream().mapToInt(n -> n).sum();
        System.out.println(numbers);
        System.out.println("Suma "+s);
        int max = numbers.stream().max(Integer::compare).get();
        System.out.println("Maximul este " + max);
    int min = numbers.stream().min(Integer::compare).get();
    System.out.println("Minimul este " + min);
    List<Integer>sortat=numbers.stream().filter(n -> n >10 && n<20).toList();
        System.out.println("Lista filtrata este: "+sortat);
        List<Double>lista=numbers.stream().map(e -> Double.valueOf(e)).toList();
        System.out.println("Lista double este: "+lista);
        Optional<Integer> gaseste = numbers.stream().filter(n -> n == 12).findAny();
        if(gaseste.isPresent()){
        System.out.println("Numarul a fost gasit:  " + gaseste);
    }
        else{
            System.out.println("Numarul nu a fost gasit");
        }
        //9.3.2
        List<Integer>list= Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer>patrate=list.stream().distinct().map(e -> e*e).toList();
        System.out.println("Lista de patrate este: "+patrate);
        //9.3.3
        String t = "Acesta este un program scris cu java 8 si expresii lambda";
        List<String> text = Arrays.asList(t.split(" "));
        long nr=text.stream().filter(n -> n.length() >= 5).count();
        System.out.print("Cuvinte mai lungi de 5 caractere: "+nr);
        List<String> Cuvinte=text.stream().filter(n -> n.length() >= 5).toList();
        System.out.println(" ,iar lista acestora este: "+Cuvinte);
        List<String> Ordonata =Cuvinte.stream().sorted().toList();
        System.out.println("Lista noua ordonata este: "+Ordonata);
       String p=text.stream().filter(n->n.startsWith("p")).findAny().get();
       System.out.println("Cuvant cu litera p: "+p);
    }
}
