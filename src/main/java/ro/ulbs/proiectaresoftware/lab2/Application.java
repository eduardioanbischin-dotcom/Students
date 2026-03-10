package ro.ulbs.proiectaresoftware.lab2;

import java.util.*;

public class Application {
    static void main() {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusy = new ArrayList();
        Set<Integer> zset = new TreeSet();
        List<Integer> xMiusy = new ArrayList();
        int p = 4;
        List<Integer> xPlusYLimitedByp = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Integer nr = random.nextInt(11);
            x.add(nr);
        }
        for (int i = 0; i < 7; i++) {
            Integer nr = random.nextInt(11);
            y.add(nr);
        }
        xPlusy.addAll(x);
        xPlusy.addAll(y);
        xMiusy.addAll(xPlusy);
        xMiusy.removeAll(y);
        zset.addAll(x);
        zset.retainAll(y);
        for (Integer n : xPlusy) {
            if (n <= 4) {
                xPlusYLimitedByp.add(n);
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(xPlusy);
        Collections.sort(xMiusy);
        Collections.sort(xPlusYLimitedByp);
        System.out.println(x);
        System.out.println(y);
        System.out.println(xPlusy);
        System.out.println(xMiusy);
        System.out.println(zset);
        System.out.println(xPlusYLimitedByp);



    }
}