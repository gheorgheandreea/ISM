package ro.ulbs.paradigme.lab2;

public class Triangle extends Form {
    private float Height,base;
    public Triangle(){
        super();
        this.Height = 0;
        this.base = 0;
    }
    public Triangle(String color,float height, float base) {
        super(color);
        this.Height = height;
        this.base = base;
    }
    @Override
    public float getArea(){
        return (Height*base)/2.0F;
    }
    @Override
    public String toString(){
        return super.toString()+" And Triangle area is "+getArea();
    }


    public String getcolor(){
        return this.getColor();
  }
    public boolean equals(Triangle obj) {
            if(this.getArea()==obj.getArea() && this.getcolor().equals(obj.getcolor())){
            return true;
        }
        else return false;
    }
}
