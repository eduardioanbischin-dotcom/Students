package ro.ulbs.proiectaresoftware.lab7.forms;

public class Form {
    private static int counter;
    private final String color;

    public Form() {
        color = "white";
        counter++;
    }

    public Form(String color) {
        this.color = color;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public float getArea() {
        return 0;
    }

    public String toString() {
        return "This form has the color " + color;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form f) {
            if (this.color == null && f.color == null) {
                return true;
            } else return this.color != null && f.color != null && this.color.compareTo(f.color) == 0;
        }
        return false;
    }
}
