import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filename) throws IOException {
        Map<String, Integer> frequencyMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().split("[^a-zA-Z]+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return frequencyMap;
    }
    
    public static void main(String[] args) throws IOException {
        String testText = "test.txt";
        PrintWriter writer = new PrintWriter(testText);
        writer.println("Hello world, hello Java!");
        writer.close();
        
        Map<String, Integer> result = countWordFrequency(testText);
        System.out.println(result);
        
        new File(testText).delete();
    }
}