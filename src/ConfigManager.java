import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String filename = "config.properties";

        try (FileInputStream in = new FileInputStream(filename)) {
            properties.load(in);
            System.out.println("Current value: " + properties.getProperty("key"));

            properties.setProperty("key", "newValue");

            try (FileOutputStream out = new FileOutputStream(filename)) {
                properties.store(out, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
