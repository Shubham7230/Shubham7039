import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String lang = br.readLine();

            FileWriter fw = new FileWriter("userinfo.txt");
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + lang + "\n");
            fw.close();

            System.out.println("Information saved to userinfo.txt");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
