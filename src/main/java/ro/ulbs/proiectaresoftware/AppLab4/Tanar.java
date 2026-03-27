package ro.ulbs.proiectaresoftware.AppLab4;

public class Tanar {
    private String name;
    private int age;
    private String address;

    public Tanar(String name,int age,String address) {
        this.name = name;
        this.age=age;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + "," + age +"," + address;
    }
}
