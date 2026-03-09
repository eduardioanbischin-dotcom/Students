package ro.ulbs.proiectaresoftware.lab1;

public class Application {
    static void main() {
        String alfabet_mare = "";
        String alfabet_mic = " ";

        for (int i = 65; i <= 90; i++) {
            String c = String.valueOf((char) i);
            alfabet_mare = alfabet_mare + c + " ";


        }
        for (int i = 97; i <= 122; i++) {
            String c = String.valueOf((char) i);
            alfabet_mic = alfabet_mic + c + " ";


        }
        System.out.println(alfabet_mic);
        System.out.println(alfabet_mare);
    }
}
