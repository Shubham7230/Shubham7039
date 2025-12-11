import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        File input = new File("input.txt");
        File output = new File("output.txt");

        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(output);
            BufferedWriter bw = new BufferedWriter(fw);

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase(ch));
            }

            br.close();
            bw.close();

            System.out.println("File converted to lowercase successfully");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
