package ro.ulbs.paradigme.lab6.Ex1;

public class IntCalculator {
    private int state;

    public IntCalculator(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
    public IntCalculator Add(int n){
          state += n;
        return this;
    }
    public IntCalculator subtract(int n){
        state -= n;
        return this;
    }
    public IntCalculator multiply(int n){
        state *= n;
        return this;
    }
    public int result() {
        return state;
    }
    public IntCalculator clear() {
        state = 0;
        return this;
    }
}
