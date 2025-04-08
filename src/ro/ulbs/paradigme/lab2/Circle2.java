package ro.ulbs.paradigme.lab2;

public class Circle2 extends Form {
    private float radius;
    public Circle2() {
        super();
        this.radius = 0;
    }
    public Circle2(String color,float radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    public float getArea(){
        return (float) (radius * radius*Math.PI);
    }
    @Override
    public String toString(){
        return super.toString()+" And Circle area is "+getArea();
    }
}
