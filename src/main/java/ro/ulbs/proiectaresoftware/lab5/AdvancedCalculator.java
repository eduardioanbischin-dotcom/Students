package ro.ulbs.proiectaresoftware.lab5;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int state){
        super(state);
    }
    public AdvancedCalculator divide(int state){
   this.state/=state;
   return this;
    }
    public AdvancedCalculator power(int state){
        this.state*=state;
        return this;

    }
    public AdvancedCalculator rad(int state){
        double stated=state;
        this.state=(int) Math.sqrt(stated);
        return this;
    }
}
