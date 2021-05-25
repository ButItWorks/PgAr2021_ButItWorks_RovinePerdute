import java.util.HashMap;
import java.util.Map;

public class Citta {

    private static final int MAX_INIT_PESO = 9999;

    private int id;
    private String nome;
    private Posizione posizione;
    private int altezza;
    private Map<Citta, Integer> collegamenti = new HashMap<>();

    public Citta() {
        super();
    }

    public Citta(int id, String nome, Posizione posizione, int altezza) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.altezza = altezza;
    }

    public Citta(int id, String nome, Posizione posizione, int altezza, HashMap<Citta, Integer> collegamenti) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.altezza = altezza;
        this.collegamenti = collegamenti;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public Map<Citta, Integer> getCollegamenti() {
        return collegamenti;
    }

    public void inserisciCollegamento(Citta citta, int pesoPercorso) {
        collegamenti.put(citta, pesoPercorso);
    }

    public void inserisciCollegamento(Citta citta) {
        collegamenti.put(citta, MAX_INIT_PESO);
    }

    public void inserisciPesoCollegamento(Citta cittaDestinazione, int peso) {
        for (Citta citta : this.collegamenti.keySet()) {
            if(citta.getNome().equals(cittaDestinazione.getNome())) {
                this.inserisciCollegamento(cittaDestinazione, peso);
                break;
            }
        }
    }

}
