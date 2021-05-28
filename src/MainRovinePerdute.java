import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainRovinePerdute {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        ArrayList<Citta> listaCitta = XmlUtilities.leggiMappaCittaXml();

        for (Citta c : listaCitta) {
            System.out.println("********************************");
            System.out.println("id: " + c.getId());
            System.out.println("nome: " + c.getNome());
            System.out.println("coordinata x: " + c.getPosizione().getX());
            System.out.println("coordinata y: " + c.getPosizione().getX());
            System.out.println("altezza: " + c.getAltezza());
            System.out.println("collegamenti:");
            for (Citta city : c.getCollegamenti()) {
                System.out.println("***********************");
                System.out.println("id: " + city.getId());
                System.out.println("nome: " + city.getNome());
                System.out.println("***********************");
            }
            System.out.println("********************************");
        }

        ArrayList<Citta> percorsoMinimoTon = new ArrayList<>();
        percorsoMinimoTon = CalcoloPercorso.calcoloPercorsoMinimo(listaCitta, listaCitta.get(0), listaCitta.get(listaCitta.size()-1), true);
        ArrayList<Citta> percorsoMinimoMet = new ArrayList<>();
        percorsoMinimoMet = CalcoloPercorso.calcoloPercorsoMinimo(listaCitta, listaCitta.get(0), listaCitta.get(listaCitta.size()-1), false);

        System.out.println("*********PERCORSO MINIMO TON ********************");

        for (Citta c : percorsoMinimoTon) {
            System.out.println("id: " + c.getId());
            System.out.println("nome citta: " + c.getNome());
            System.out.println("*************************************+");
        }

        System.out.println(CalcoloPercorso.getBenzinaTonathiu());

        System.out.println("*********PERCORSO MINIMO MET ********************");

        for (Citta c : percorsoMinimoMet) {
            System.out.println("id: " + c.getId());
            System.out.println("nome citta: " + c.getNome());
            System.out.println("*************************************+");
        }

        System.out.println(CalcoloPercorso.getBenzinaMetztli());

    }

}
