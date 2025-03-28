package ro.ulbs.paradigme.lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        try {
            printSmallTextFile("in.txt");
            System.out.println("\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5.3.2
        try {
            System.out.print("Writing outrand.txt ... ");
            List<String> lines = generateLines();
            writeSmallTextFile(lines, "outrand.txt");
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void printSmallTextFile(String fileName) throws IOException {
        System.out.println("Using Files.readAllLines:");
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        List<String> outputLines = new ArrayList<>();
        String s = new String(Files.readAllBytes(path));
         //punctul a
        for (String line : allLinesInMemory) {
            System.out.println(line + "\n");
            outputLines.add(line+"\n");
        }
        //punctul b
        s = s.replaceAll("\\n", "");
        s = s.replaceAll("\\r", "");
        System.out.println("\n Split by point char: \n");
        outputLines.add("\n Split by point char:\n");
        String[] sentence = s.split("\\.");
        for (String g : sentence) {
            System.out.print(g + "\n");
            outputLines.add(g+"\n");
        }
        writeSmallTextFile(outputLines, "out.txt");
    }
    static void writeSmallTextFile(List<String> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, lines);
    }
    //5.3.2
    public static String generateWord(Random rand) {
        int countLetters = 'z' - 'a' + 1;
        char[] word = new char[4];
        for (int i = 0; i < 4; i++) {
            word[i] = (char) ('a' + rand.nextInt(countLetters));
        }
        return new String(word);
    }
    public static List<String> generateLines() {
        Random rand = new Random();
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            String[] words = new String[10];
            for (int j = 0; j < 10; j++) {
                words[j] = generateWord(rand);
            }
            Arrays.sort(words);
            lines[i] = String.join(" ", words);
        }
        return Arrays.asList(lines);
    }
}


