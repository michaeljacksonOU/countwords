import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("this code will take 4 words and write 100 random words to a file and then count the number of times each word appears in the file");
        System.out.println("Enter the first word");
        String word1 = scanner.nextLine();
        System.out.println("Enter the second word");
        String word2 = scanner.nextLine();
        System.out.println("Enter the third word");
        String word3 = scanner.nextLine();
        System.out.println("Enter the fourth word");
        String word4 = scanner.nextLine();
        String[] Words = {word1, word2, word3, word4};
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("output.txt"))){
            for (int i = 0; i < 100; i++) {
                writer.write(Words[rand.nextInt(Words.length)] + "\n");
            }
        }
        Map<String, Integer> WordCount = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader("output.txt"))){
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                WordCount.put(line, WordCount.getOrDefault(line, 0) + 1);
            }
        
        }
        for (Map.Entry<String, Integer> entry : WordCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

