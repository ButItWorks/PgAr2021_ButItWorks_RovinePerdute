import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlUtilities {

    public static ArrayList<Citta> leggiMappaCittaXml() throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String filepath = "test_file/nomefile.xml";

        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader("inputPersone", new FileInputStream(filepath));

        ArrayList<Citta> listaCitta = new ArrayList<Citta>();
        Citta citta = new Citta();

        // codice da fare
        // ...
        // fine codice da fare

        return listaCitta;
    }

    public static void produciOutput() throws XMLStreamException, FileNotFoundException {
        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        String filepath = "outputFiles/nomefile.xml";


    }
}
