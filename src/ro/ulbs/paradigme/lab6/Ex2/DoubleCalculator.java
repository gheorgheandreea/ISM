package ro.ulbs.paradigme.lab6.Ex2;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(double state) {

        this.state= state;
    }
    public DoubleCalculator add(double n) {
        this.state = (Double)this.state + n;
        return this;
    }
    public DoubleCalculator subtract(double n){
        this.state = (Double)this.state - n;
        return this;
    }
    public DoubleCalculator multiply(double n){
        this.state = (Double)this.state * n;
        return this;
    }
    public DoubleCalculator divide(double n){
        this.state = (Double)this.state / n;
        return this;
    }
    @Override
    public void init() {
        state=0;
    }
}
