package ro.ulbs.proiectaresoftware.AppLab4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj", "Simina", "Alba-Iulia", "Marius", "Medias", "Mihai", "Cisnadie", "Daniela", "Sibiu");
        for (Integer i: varste.values()){
            System.out.println("varsta este "+ i);
            }
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        for (Map.Entry<String, Integer> e : varste.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }

        HashMap<String, Tanar> tanar = new HashMap<>();
        for (Map.Entry<String, Integer> e : varste.entrySet()){
String nume=e.getKey();
            Integer i=e.getValue();
            String adresa="Unkown";
            tanar.put(nume,new Tanar(nume,i,adresa));
        }
        for (Map.Entry<String,Tanar> t: tanar.entrySet()){
            System.out.println(t.getKey()+" "+ t.getValue().toString());
        }
    }}



