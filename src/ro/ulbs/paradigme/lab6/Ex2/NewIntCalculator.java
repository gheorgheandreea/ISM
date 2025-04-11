package ro.ulbs.paradigme.lab6.Ex2;

public class NewIntCalculator extends ACalculator{

    public NewIntCalculator(int state) {

        this.state= state;
    }
    public NewIntCalculator add(int n) {
        this.state = (Integer)this.state + n;
        return this;
    }
    public NewIntCalculator subtract(int n){
        this.state = (Integer)this.state - n;
        return this;
    }
    public NewIntCalculator multiply(int n){
        this.state = (Integer)this.state * n;
        return this;
    }
    public NewIntCalculator divide(int n){
        this.state = (Integer)this.state / n;
        return this;
    }

    @Override
    public void init() {
        state=0;
    }
}
