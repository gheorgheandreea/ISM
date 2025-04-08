package ro.ulbs.paradigme.lab6.Ex1;

public class App {
    public static void main(String args[]){
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.Add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);
    }
}
