package ro.ulbs.proiectaresoftware.lab5;

public class IntCalculator {
    int state;
    public  IntCalculator(int state){
        this.state=state;
    }
   public IntCalculator add( int state){
       this.state+=state;
       return this;
   }
   public IntCalculator subtract(int state){
       this.state-=state;
       return this;
   }
   public IntCalculator multiply(int state){
       this.state*=state;
       return this;
   }
   public IntCalculator result(){
       return this;
   }
   public IntCalculator clear(){
       this.state=0;
       return this;
   }

}
