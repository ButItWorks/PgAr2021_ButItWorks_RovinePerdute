import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CalcoloPercorso {

    private static double benzinaMetztli;  //carburante team Metztli
    private static double benzinaTonathiu;  //carburante team Tonathiu

    public static double getBenzinaMetztli() {
        return benzinaMetztli;
    }

    public static double getBenzinaTonathiu() {
        return benzinaTonathiu;
    }

    private static void resetMappaCitta(ArrayList<Citta> listaCitta) {
        for (Citta c : listaCitta) {
            c.setDistanza(Double.MAX_VALUE);
            c.setCittaPrecedente(new Citta());
        }
    }

    private static Citta getCittaDistanzaMinore(Set<Citta> cittaDisponibili) {
        Citta cittaDistanzaMinima = new Citta();
        double distanzaMinima = Integer.MAX_VALUE;

        for (Citta citta: cittaDisponibili) {
            double nodeDistance = citta.getDistanza();
            if (nodeDistance < distanzaMinima) {
                distanzaMinima = nodeDistance;
                cittaDistanzaMinima = citta;
            }
        }

        return cittaDistanzaMinima;
    }
    private static void calcolaDistanzaMinima(Citta cittaPartenza, Citta cittaArrivo, double distanza) {
        double distanzaTotale = cittaPartenza.getDistanza() + distanza;
        if (distanzaTotale < cittaArrivo.getDistanza()) {
            cittaArrivo.setDistanza(distanzaTotale);
            cittaArrivo.setCittaPrecedente(cittaPartenza);
            cittaArrivo.setNumeroCittaPrecedenti(cittaPartenza.getNumeroCittaPrecedenti() + 1);
        }
        else if(distanzaTotale == cittaArrivo.getDistanza() && (cittaPartenza.getNumeroCittaPrecedenti() + 1) < cittaArrivo.getNumeroCittaPrecedenti()) {
            cittaArrivo.setCittaPrecedente(cittaPartenza);
            cittaArrivo.setNumeroCittaPrecedenti(cittaPartenza.getNumeroCittaPrecedenti() + 1);
        }
        /*
        else if(distanzaTotale == cittaArrivo.getDistanza() && (cittaPartenza.getNumeroCittaPrecedenti() + 1) < cittaArrivo.getNumeroCittaPrecedenti() && ) {

        }
        */

    }

    public static ArrayList<Citta> calcoloPercorsoMinimo(ArrayList<Citta> mappa, Citta partenza, Citta arrivo, boolean isPercorsoTonatiuh) {
        resetMappaCitta(mappa);
        partenza.setDistanza(0);
        partenza.setNumeroCittaPrecedenti(0);
        Set<Citta> cittaValutate = new HashSet<>();
        Set<Citta> cittaDaValutare = new HashSet<>();
        ArrayList<Citta> percorsoMinore = new ArrayList<>();
        cittaDaValutare.add(partenza);

        while (cittaDaValutare.size() != 0) {
            Citta cittaCorrente = getCittaDistanzaMinore(cittaDaValutare);
            cittaDaValutare.remove(cittaCorrente);
            for (Citta cittaAdiacente: cittaCorrente.getCollegamenti()) {
                double distanza = 0;

                if(isPercorsoTonatiuh) {
                    distanza = cittaCorrente.getPosizione().distanzaEuclidea(cittaAdiacente.getPosizione());
                } else {
                    distanza = cittaCorrente.dislivello(cittaAdiacente.getAltezza());
                }

                if (!cittaValutate.contains(cittaAdiacente)) {
                    calcolaDistanzaMinima(cittaCorrente, cittaAdiacente, distanza);
                    cittaDaValutare.add(cittaAdiacente);
                }
            }
            cittaValutate.add(cittaCorrente);
        }

        do {
            percorsoMinore.add(arrivo);
            arrivo = arrivo.getCittaPrecedente();
        } while(arrivo.getId() != partenza.getId());

        if(isPercorsoTonatiuh) {
            benzinaTonathiu = mappa.get(mappa.size()-1).getDistanza();
        } else {
            benzinaMetztli = mappa.get(mappa.size()-1).getDistanza();
        }

        percorsoMinore.add(partenza);
        Collections.reverse(percorsoMinore);
        return percorsoMinore;
    }

    /*
    public static ArrayList<Citta> calcoloPercorsoTonatiuh(ArrayList<Citta> listaCitta){
        ArrayList<Citta> percorsoMinore = new ArrayList<>();
        int counter = 0;
        double distanza = 0.0;

        //Setto il campo base
        Citta cittaCorrente = listaCitta.get(0);
        Citta nextCity = new Citta();
        listaCitta.get(0).setCittaPrecedente(listaCitta.get(0));
        listaCitta.get(0).setDistanza(0);

        while(counter < listaCitta.size() && cittaCorrente.getId() != (listaCitta.size() - 1)) {
            for (Citta cittaCollegamento : cittaCorrente.getCollegamenti()) {
                distanza = cittaCorrente.getDistanza() + cittaCorrente.getPosizione().distanzaEuclidea(cittaCollegamento.getPosizione());

                if(distanza < cittaCollegamento.getDistanza()) {
                    cittaCollegamento.setDistanza(distanza);
                    cittaCollegamento.setCittaPrecedente(cittaCorrente);
                }
            }

            cittaCorrente = nextCity(cittaCorrente.getCollegamenti());
            counter++;
        }

        do {
            percorsoMinore.add(cittaCorrente);
            cittaCorrente = cittaCorrente.getCittaPrecedente();
        } while(cittaCorrente.getId() != 0);

        percorsoMinore.add(cittaCorrente);

        Collections.reverse(percorsoMinore);

        return percorsoMinore;
    }

    public static ArrayList<Citta> calcoloPercorsoMetztli(ArrayList<Citta> listaCitta){
        ArrayList<Citta> percorsoMinore = new ArrayList<>();
        int counter = 0;
        double distanza = 0.0;

        //Setto il campo base
        Citta cittaCorrente = listaCitta.get(0);
        Citta nextCity = new Citta();
        listaCitta.get(0).setCittaPrecedente(listaCitta.get(0));
        listaCitta.get(0).setDistanza(0);

        while(counter < listaCitta.size() && cittaCorrente.getId() != (listaCitta.size() - 1)) {
            for (Citta cittaCollegamento : cittaCorrente.getCollegamenti()) {
                distanza = cittaCorrente.getDistanza() + cittaCorrente.dislivello(cittaCollegamento.getAltezza());

                if(distanza < cittaCollegamento.getDistanza()) {
                    cittaCollegamento.setDistanza(distanza);
                    cittaCollegamento.setCittaPrecedente(cittaCorrente);
                }
            }

            cittaCorrente.setChecked(true);
            cittaCorrente = nextCity(cittaCorrente.getCollegamenti());
            counter++;
        }

        do {
            percorsoMinore.add(cittaCorrente);
            cittaCorrente = cittaCorrente.getCittaPrecedente();
        } while(cittaCorrente.getId() != 0);

        percorsoMinore.add(cittaCorrente);

        Collections.reverse(percorsoMinore);

        return percorsoMinore;
    }
    */
}
