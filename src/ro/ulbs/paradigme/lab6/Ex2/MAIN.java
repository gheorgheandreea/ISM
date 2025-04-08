package ro.ulbs.paradigme.lab6.Ex2;

public class MAIN {
    public static void main(String args[]){
        NewIntCalculator i= new NewIntCalculator(10);
        DoubleCalculator d = new DoubleCalculator(10);
        int resultI =(Integer)i.add(5).subtract(3).multiply(2).result();
        double resultD = (Double)d.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultatul operatiei cu integer: " + resultI);
        System.out.println("Rezultatul operatiei cu double: " + resultD);
    }
}
