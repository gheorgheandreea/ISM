package ro.ulbs.paradigme.lab3;

    public class Form1 {
        private String color;
        private static int counter=0;
        Form1(){
            this.color="red";
            counter++;
        }
        public Form1(String color){
            this.color=color;
            counter++;
        }

        public float getArea(){
            return 0;
        }
        public String getColor(){
            return this.color;
        }
        public static int getCounter(){

            return counter;
        }
        @Override
        public String toString(){
            return "This form has the color " +color;
        }
    }

