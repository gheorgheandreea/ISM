package ro.ulbs.paradigme.lab2;
public class Form {
    private String color;
    Form(){
        this.color="white";
    }
   public Form(String color){
        this.color=color;
    }
    public float getArea(){
        return 0;
    }
    public String getColor(){
        return this.color;
    }
    @Override
   public String toString(){
     return "This form has the color " +color;
   }
}
