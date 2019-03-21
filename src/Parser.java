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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class Parser extends DefaultHandler {

    public static  ArrayList<Human> humans = new ArrayList<>();
    public void printoutHumans (){
        System.out.println(humans.size());
        for (Human human:humans){
            System.out.println(human.getClass());
        }
    }

    public void saxParser () throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser =factory.newSAXParser();
        Parser saxParse = new Parser();
        try {
            parser.parse("text.txt", saxParse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("<"+qName+">");
        if(qName.equals("professor")){
            Professor prof = new Professor(attributes.getValue(0),attributes.getValue(1),attributes.getValue(2));
            humans.add(prof);
        }
        if(qName.equals("member")) {
            humans.add(new Employee(attributes.getValue(0)));
        }
        if(qName.equals("student")) {
            humans.add(new Student(attributes.getValue(0), attributes.getValue(1),attributes.getQName(2)));
        }
        /**for(int i=0; i<= attributes.getLength();i++){
         if(attributes.getQName(i)!=null){
         System.out.print(""+attributes.getQName(i)+"="+attributes.getValue(i));
         }
         }**/
    }
    public Person [] parseGson (String stringJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Person [] person = gson.fromJson(stringJson, Person [].class);
        for (Person pers: person){
            System.out.println(pers.name);
        }
        return person;
    }
}
