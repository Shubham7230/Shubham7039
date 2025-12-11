import java.io.*;

public class Studentdata {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));
            dos.writeInt(101);
            dos.writeUTF("Shubham");
            dos.writeDouble(8.7);
            dos.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            dis.close();
            System.out.println(roll + " " + name + " " + gpa);
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}