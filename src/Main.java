import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Main {
    private final static Object SYN_OBJECT = new Object();

    static String string = "";
    static Loader loader = new Loader();
    static Parser parser = new Parser();
    public static void main(String[] args) throws ParserConfigurationException, SAXException {


        Thread thread1 = new Thread (new Runnable(){
            public void run (){
                synchronized (SYN_OBJECT){
                    System.out.println("Начинаем работу");
                loader.httpToFile();
                try {
                    System.out.println("Ждем парсинг XML");
                    SYN_OBJECT.wait();
                    System.out.println("Получаем Json");
                    string = loader.getFile();
                    SYN_OBJECT.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        });
        Thread thread2 = new Thread (new Runnable(){
            public void run (){
                synchronized (SYN_OBJECT){
                try {
                    System.out.println("Парсим XML");
                    parser.saxParser();
                    System.out.println("Ждем Json");
                    SYN_OBJECT.notify();
                    SYN_OBJECT.wait();
                } catch (ParserConfigurationException | SAXException | InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println("Парсим Json");
                    parser.parseGson(string);
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
