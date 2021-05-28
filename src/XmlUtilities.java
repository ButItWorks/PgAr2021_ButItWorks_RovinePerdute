import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlUtilities {

    public static ArrayList<Citta> leggiMappaCittaXml() throws XMLStreamException, FileNotFoundException {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            String filepath = "test_file/PgAr_Map_5.xml";
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("inputCitta", new FileInputStream(filepath));

            ArrayList<Citta> mappa = new ArrayList<>();
            Citta citta = new Citta();

            while (xmlr.hasNext()) {
                if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("city")) {
                    for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                        switch (xmlr.getAttributeLocalName(i)) {
                            case "id" -> citta.setId(Integer.parseInt(xmlr.getAttributeValue(i)));
                            case "name" -> citta.setNome(xmlr.getAttributeValue(i));
                            case "x" -> citta.getPosizione().setX(Integer.parseInt(xmlr.getAttributeValue(i)));
                            case "y" -> citta.getPosizione().setY(Integer.parseInt(xmlr.getAttributeValue(i)));
                            case "h" -> citta.setAltezza(Integer.parseInt(xmlr.getAttributeValue(i)));
                        }
                    }
                }
                else if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("link")) {
                    citta.inserisciCollegamentoId(Integer.parseInt(xmlr.getAttributeValue(0)));
                }
                else if(xmlr.getEventType() == XMLStreamConstants.END_ELEMENT && xmlr.getLocalName().equals("city")) {
                    mappa.add(citta);
                    citta = new Citta();
                }
                xmlr.next();
            }

            for (Citta c : mappa) {
                for (int idCollegamento : c.getCollegamentiId()) {
                    c.getCollegamenti().add(mappa.get(idCollegamento));
                }
            }

            return mappa;

        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        return null;
    }


    public static void produciOutput() throws XMLStreamException, FileNotFoundException {
        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        String filepath = "outputFiles/nomefile.xml";


    }
}
