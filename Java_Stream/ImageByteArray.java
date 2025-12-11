import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        File source = new File("image.jpg");
        File dest = new File("copy_image.jpg");

        try {
            FileInputStream fin = new FileInputStream(source);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytes;
            while ((bytes = fin.read(buffer)) != -1) {
                bout.write(buffer, 0, bytes);
            }
            fin.close();

            byte[] imageBytes = bout.toByteArray();
            ByteArrayInputStream bin = new ByteArrayInputStream(imageBytes);
            FileOutputStream fout = new FileOutputStream(dest);

            while ((bytes = bin.read(buffer)) != -1) {
                fout.write(buffer, 0, bytes);
            }

            fout.close();
            bin.close();

            System.out.println("Image converted and saved successfully");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
