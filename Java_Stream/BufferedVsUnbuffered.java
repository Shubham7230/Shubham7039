import java.io.*;

public class BufferedVsUnbuffered {
    public static void main(String[] args) {
        File source = new File("largefile.bin");
        File dest1 = new File("copy_unbuffered.bin");
        File dest2 = new File("copy_buffered.bin");

        long start1 = System.nanoTime();
        copyUnbuffered(source, dest1);
        long end1 = System.nanoTime();
        long timeUnbuffered = end1 - start1;

        long start2 = System.nanoTime();
        copyBuffered(source, dest2);
        long end2 = System.nanoTime();
        long timeBuffered = end2 - start2;

        System.out.println("Unbuffered Time: " + timeUnbuffered + " ns");
        System.out.println("Buffered Time: " + timeBuffered + " ns");
    }

    static void copyUnbuffered(File source, File dest) {
        try (FileInputStream fin = new FileInputStream(source);
             FileOutputStream fout = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void copyBuffered(File source, File dest) {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bin.read(buffer)) != -1) {
                bout.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
