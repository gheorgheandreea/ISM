package ro.ulbs.paradigme.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Student {
    private String nume;
    private String grupa;
    private List<Integer> note;
    Random random=new Random();
    public Student(String nume, String grupa) {
        this.nume=nume;
        this.grupa=grupa;
        this.note=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            note.add(random.nextInt(7) + 4);
        }
    }
    public Student(String nume, String grupa, List<Integer> note) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }
    public double getMedie() {
        double suma = 0;
        for (int nota : note) {
            suma += nota;
        }
        return suma / note.size();
    }

    public long getNrRestante() {
        int restante = 0;
        for (int nota : note) {
            if (nota < 5) {
                restante++;
            }
        }
        return restante;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) && Objects.equals(grupa, student.grupa) && Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, grupa, note);
    }
    @Override
    public String toString() {
        return nume + " - " + grupa + " - Note: " + note + " - Medie: " + getMedie();
    }
}
