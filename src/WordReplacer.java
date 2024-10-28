import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class WordReplacer {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String wordToReplace = "oldWord";
        String newWord = "newWord";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(wordToReplace, newWord);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
