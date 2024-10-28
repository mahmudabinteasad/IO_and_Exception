import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileMerger {
    public static void main(String[] args) {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String mergedFile = "merged.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFile))) {
            for (String file : new String[]{file1, file2}) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
