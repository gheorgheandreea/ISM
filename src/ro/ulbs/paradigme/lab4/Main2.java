package ro.ulbs.paradigme.lab4;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList();
        Set<Integer> z1Set = new TreeSet();
        List<Integer> xMinusY = new ArrayList();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            x.add(r.nextInt(0,10));
        }

        for (int i = 0; i < 7; i++) {
            y.add(r.nextInt(0,10));
        }
        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x:  " + x);
        System.out.println("Lista y:  " + y);
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println("xPLusY: " + xPlusY);

        z1Set.addAll(x);
        z1Set.retainAll(y);
        System.out.println("z1Set: " + z1Set);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("xMinusY: " + xMinusY);

        for (int num : xPlusY) {
            if (num <= p) {
                xPlusYLimitedByP.add(num);
            }
        }
        System.out.println("xPlusYLimitedByP: " + xPlusYLimitedByP);

    }
}