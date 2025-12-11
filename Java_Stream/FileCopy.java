import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File dest = new File("destination.txt");

        if (!source.exists()) {
            System.out.println("Source file does not exist");
            return;
        }

        try (FileInputStream fin = new FileInputStream(source);
             FileOutputStream fout = new FileOutputStream(dest)) {

            int data;
            while ((data = fin.read()) != -1) {
                fout.write(data);
            }

            System.out.println("File copied successfully");
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
