import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainRovinePerdute {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        Constants.settaVariabili("finfn");

        System.out.println("*********PERCORSO MINIMO TON ********************");

        for (Citta c : Constants.getPercorsoMinimoTonatiuh()) {
            System.out.println("id: " + c.getId());
            System.out.println("nome citta: " + c.getNome());
            System.out.println("*************************************+");
        }

        System.out.println(Constants.getBenzinaTonathiu());

        System.out.println("*********PERCORSO MINIMO MET ********************");

        for (Citta c : Constants.getPercorsoMinimoMetztli()) {
            System.out.println("id: " + c.getId());
            System.out.println("nome citta: " + c.getNome());
            System.out.println("*************************************+");
        }

        System.out.println(Constants.getBenzinaMetztli());

    }

}
