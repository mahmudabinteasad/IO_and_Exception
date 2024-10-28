import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class BinaryFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.bin";
        String destFile = "dest.bin";

        try (FileInputStream in = new FileInputStream(sourceFile);
             FileOutputStream out = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
