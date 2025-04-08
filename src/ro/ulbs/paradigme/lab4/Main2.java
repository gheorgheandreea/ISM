package ro.ulbs.paradigme.lab4;

import java.io.*;
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
        System.out.println(" ");

            // exercitiul 4.5.2
        System.out.println("EXERCITIUL 4.5.2\n");
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("Popescu Ion",  "222_3"));
        studenti.add(new Student("Gheorghe Marian",  "221_1"));
        studenti.add(new Student("Popa Alexia", "222_3"));
        studenti.add(new Student("Andronache Elena ","222_3"));
        studenti.add(new Student("Albeanu Andreea",  "221_1"));
        studenti.add(new Student("Alexe Cristina", "221_1"));

        studenti.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int result = s1.getGrupa().compareTo(s2.getGrupa());
                if (result == 0) {
                    return s1.getNume().compareTo(s2.getNume());
                }
                return result;
            }
        });
        System.out.println("Ordonare alfabetică pe grupe:");
        for (Student s : studenti) {
            System.out.println(s);
        }
        List<Student> integralisti = new ArrayList<>();
        for (Student s : studenti) {
            if (s.getNrRestante() == 0) {
                integralisti.add(s);
            }
        }
        integralisti.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMedie(), s1.getMedie());
            }
        });
        System.out.println("\nIntegraliști ordonați descrescător după medie:");
        for (Student s : integralisti) {
            System.out.println(s);
        }

        List<Student> restantieri = new ArrayList<>();
        for (Student s : studenti) {
            if (s.getNrRestante() > 0) {
                restantieri.add(s);
            }
        }
        restantieri.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Long.compare(s1.getNrRestante(), s2.getNrRestante());
            }
        });

        System.out.println("\nRestanțieri ordonați crescător după numărul de restanțe:");
        for (Student s : restantieri) {
            System.out.println(s);
        }

        String fileName = "input.txt";

        File file = new File(fileName);
        System.out.println("Calea absolută căutată: " + file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("Fișierul NU există! Asigură-te că 'input.txt' este în același director cu programul.");
            return;
        }

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                if (data.length < 3) continue; // Evităm erori dacă linia e incorectă

                String nume = data[0] + " " + data[1];
                String grupa = data[2];
                List<Integer> note = new ArrayList<>();

                for (int i = 3; i < data.length; i++) {
                    try {
                        note.add(Integer.parseInt(data[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Eroare la citirea notei: " + data[i]);
                    }
                }

                studenti.add(new Student(nume, grupa, note));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Eroare: Fișierul nu a fost găsit.");
        }

        // Creare Map pentru numărarea aparițiilor
        Map<Student, Integer> mapStudenti = new HashMap<>();

        for (Student s : studenti) {
            mapStudenti.put(s, mapStudenti.getOrDefault(s, 0) + 1);
        }

        // Afișare rezultate
        System.out.println("Număr apariții studenți:");
        for (Map.Entry<Student, Integer> entry : mapStudenti.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " apariții");
        }
    }
}
