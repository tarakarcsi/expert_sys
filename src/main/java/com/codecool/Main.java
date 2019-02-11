import com.codecool.XMLParser;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getWelcomeString());
        XMLParser load = new XMLParser();
        load.loadXmlDocument("src/main/resources/facts.xml");
    }
}
