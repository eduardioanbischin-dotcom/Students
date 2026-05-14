package ro.ulbs.proiectaresoftware.lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        ArrayList<Integer> numere = new ArrayList<>();
        Random random = new Random();
        int max = 25;
        int min = 5;
        for (int i = 0; i < 10; i++) {
            int nr = random.nextInt((max - min + 1) + min);
            numere.add(nr);
        }
        System.out.println(numere);
        int sum= numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("suma este "+sum);
        int maxnr=numere.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("maximul este "+maxnr);
        int minnr=numere.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("minimul este "+minnr);
        List<Integer> criteriu1=numere.stream().filter(nr->nr>=10 && nr<=20).collect(Collectors.toList());
        System.out.println(criteriu1);
        List<Double> critreriu2=numere.stream().map(Double::valueOf).collect(Collectors.toList());
        System.out.println(critreriu2);
        boolean criteriu3=numere.stream().anyMatch(n->n==12);
        System.out.println(criteriu3);

        //ex2

      String text="Acesta este un program scris in java pentru expresii lambda";
      List<String>cuvinte=Arrays.asList(text.split(" "));
      List<String> criteriu_1=cuvinte.stream().filter(s -> s.length()>=5).toList();
        System.out.println(criteriu_1);
      List<String> criteriu_2=cuvinte.stream().sorted().toList();
        System.out.println(criteriu_2);
        String criteriu_3=cuvinte.stream().filter(s -> s.startsWith("p")).findAny().toString();
        System.out.println(criteriu_3);
    }
}
