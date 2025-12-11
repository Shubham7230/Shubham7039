import java.io.*;

public class LargeFileErrorReader {
    public static void main(String[] args) {
        File file = new File("largefile.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            br.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
