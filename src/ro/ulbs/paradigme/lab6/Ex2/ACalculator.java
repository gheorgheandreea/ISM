package ro.ulbs.paradigme.lab6.Ex2;

public abstract class  ACalculator {
    protected Object state;

    public Object result(){
        return state;
    }
    public Object clear() {
        return state=0;
    }
   public abstract void init();
}
