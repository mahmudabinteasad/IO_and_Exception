import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class JsonToXmlConverter {
    public static void main(String[] args) {
        String jsonFile = "data.json";
        String xmlFile = "output.xml";

        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }

            JSONObject json = new JSONObject(jsonBuilder.toString());
            String xml = XML.toString(json);

            try (FileWriter writer = new FileWriter(xmlFile)) {
                writer.write(xml);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
