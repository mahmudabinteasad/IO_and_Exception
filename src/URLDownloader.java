import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class URLDownloader {
    public static void main(String[] args) {
        String urlFile = "urls.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(urlFile))) {
            String url;
            while ((url = br.readLine()) != null) {
                downloadContent(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void downloadContent(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                 FileWriter writer = new FileWriter(url.getHost() + ".txt")) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    writer.write(inputLine);
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
