package ro.ulbs.paradigme.lab2;
public class Main22 {
    public static void main(String[] args) {
        Triangle tri = new Triangle("red", 2.0F, 1.1F);
        Circle2 c = new Circle2("yellow", 1.5F);
        Square sq = new Square("blue",1.2F);
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        Triangle tri2 = new Triangle("red",2.0F, 1.1F);
        System.out.println("Triangle2 equals to Triangle1: " + tri2.equals(tri));
        Triangle tri3 = new Triangle("brown", 2.0F, 1.1F);
        System.out.println("Triangle3 equals to Triangle1: " + tri.equals(tri3));
    }
}