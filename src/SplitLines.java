import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitLines {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String evenLinesFile = "evenLines.txt";
        String oddLinesFile = "oddLines.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter evenWriter = new BufferedWriter(new FileWriter(evenLinesFile));
             BufferedWriter oddWriter = new BufferedWriter(new FileWriter(oddLinesFile))) {

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    evenWriter.write(line);
                    evenWriter.newLine();
                } else {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
