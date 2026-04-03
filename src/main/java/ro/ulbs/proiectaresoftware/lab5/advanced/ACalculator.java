package ro.ulbs.proiectaresoftware.lab5.advanced;

public abstract class ACalculator {
    Object state;

    public Object result(){
        return state;
    }
    public ACalculator clear(){
        this.state=0;
        return this;
    }
      public abstract  ACalculator init();

}
