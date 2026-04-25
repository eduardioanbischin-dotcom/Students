package ro.ulbs.proiectaresoftware.lab5.advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(){init();}
    public NewIntCalculator init(){
state=0;
        return this;
    }

    public NewIntCalculator init(Integer x) {
        state = x;
        return this;
    }
    public NewIntCalculator add(Integer s){
        state=(Integer) state+s;
    return this;

    }
    public NewIntCalculator subtract(Integer s){
         state=(Integer) state-s;
    return this;
    }
    public NewIntCalculator multiply(Integer s){
         state=(Integer) state*s;
    return this;
    }

    public NewIntCalculator divide(Integer s) {
        state = (Integer) state / s;
        return this;
    }

}
