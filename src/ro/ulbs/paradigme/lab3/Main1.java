package ro.ulbs.paradigme.lab3;

import ro.ulbs.paradigme.lab2.Form;

public class Main1 {
    public static void main(String[] args) {
        Form1 f = new Form1();
        Form1 f1 = new Form1("rosu");
        Form1 f2 = new Form1("negru") ;
        System.out.println("Numarul de instante "+Form1.getCounter());
        PasswordMaker andreea = new PasswordMaker("Andreea");
        System.out.println("Generated Password: " + andreea.getPassword());
    }
}
