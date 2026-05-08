package ro.ulbs.proiectaresoftware.lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;
private  static  PasswordMaker instanta;
private static  int counter=0;
static {
    instanta=new PasswordMaker();
}
private  PasswordMaker(){}
    public static PasswordMaker getInstance(){
    counter++;
    return instanta;
    }
public static int getCounter(){
    return counter;
}

    private String name;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
    }

    public PasswordMaker(String name) {
        this.name = name;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}
