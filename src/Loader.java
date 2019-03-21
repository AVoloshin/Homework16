import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class Loader extends DefaultHandler {


   public void httpToFile () {
        try {
            URL url = new URL("https://goo.gl/tFpBDV");
            URL url2 = new URL("https://goo.gl/AZnd2V");
            HttpsURLConnection connection = (HttpsURLConnection) url2.openConnection();
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 FileWriter write = new FileWriter("text.txt")) {
                String str;
                while ((str = reader.readLine()) != null) {
                    stringBuilder.append(str);
                }
                write.write(stringBuilder.toString().replaceAll("  ",""));
            } catch (MalformedInputException e) {
                e.printStackTrace();
            }
        }catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public String getFile () {
        String stringJson = null;
        try {
            URL url = new URL("https://goo.gl/Hc8J4n");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                 FileWriter writer = new FileWriter("json.txt")){
                String str;
                while ((str=bufferedReader.readLine())!=null){
                    stringBuilder.append(str);
                }
                stringJson = stringBuilder.toString();
                writer.write(stringBuilder.toString());
            } catch (MalformedInputException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringJson;
    }
}
