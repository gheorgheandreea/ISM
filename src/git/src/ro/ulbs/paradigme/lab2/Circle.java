package ro.ulbs.paradigme.lab2;

public class Circle extends Form {
    private float radius;
    public Circle() {
        super();
        this.radius = 0;
    }
    public Circle(String color,float radius) {
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
