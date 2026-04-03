package ro.ulbs.proiectaresoftware.lab5.advanced;

public class DoubleCalculator extends ACalculator {
    public DoubleCalculator(){init();}
    public DoubleCalculator init(){
        state=0;
        return this;
    }
    public DoubleCalculator add(Double s){
        state=(Double) this.state+s;
return this;
    }
    public DoubleCalculator subtract(Double s){
         state=(Double) this.state-s;
    return this;
    }
    public DoubleCalculator multiply(Double s){
         state=(Double) this.state*s;
    return this;
    }
    }

