import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String w : words) {
                    if (w.length() > 0) {
                        map.put(w, map.getOrDefault(w, 0) + 1);
                    }
                }
            }
            br.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}
