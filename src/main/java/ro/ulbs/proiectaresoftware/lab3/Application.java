package ro.ulbs.proiectaresoftware.lab3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
public class Application {
    static void writeLargerTextFile(List<String> lines, Path p) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(p)){
            for(String line : lines){
                writer.write(line);
                writer.newLine();
            }
        }
    }
    static void main(String array[]) {

        Path input = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\in.txt");
        Path output = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\out.txt");
        try {
            List<String> lines = Files.readAllLines(input);
            List<String> linesm = new ArrayList<>();
            for (String l : lines) {
                String[] a = l.split("\\n");
                for (String p : a) {
                    linesm.add(p);

                }
            }
            for (String l2 : lines) {
                String[] b = l2.split("\\.");
                for (String p2 : b) {
                    linesm.add(p2);
                    System.out.println(linesm);
                }
                writeLargerTextFile(linesm, output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}

