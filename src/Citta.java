import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Citta {
    private int id;
    private String nome;
    private Posizione posizione = new Posizione();
    private int altezza;
    private ArrayList<Integer> collegamentiId = new ArrayList<>();
    private ArrayList<Citta> collegamenti = new ArrayList<>();
    private Citta cittaPrecedente;
    private double distanza = Double.MAX_VALUE;
    private int numeroCittaPrecedenti = Integer.MAX_VALUE;

    //costruttori
    public Citta() {
        super();
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

    public ArrayList<Integer> getCollegamentiId() {
        return collegamentiId;
    }

    public void setCollegamentiId(ArrayList<Integer> collegamentiId) {
        this.collegamentiId = collegamentiId;
    }

    public ArrayList<Citta> getCollegamenti() { return collegamenti; }

    public Citta getCittaPrecedente() {
        return cittaPrecedente;
    }

    public void setCittaPrecedente(Citta cittaPrecedente) {
        this.cittaPrecedente = cittaPrecedente;
    }

    public double getDistanza() { return distanza; }

    public void setDistanza(double distanza) {
        this.distanza = distanza;
    }

    public int getNumeroCittaPrecedenti() {
        return numeroCittaPrecedenti;
    }

    public void setNumeroCittaPrecedenti(int numeroCittaPrecedenti) {
        this.numeroCittaPrecedenti = numeroCittaPrecedenti;
    }

    //Metodi collegamento
    public int getMaxId() {
        return Collections.max(collegamentiId);
    }

    public void inserisciCollegamentoId(int id) {
        this.collegamentiId.add(id);
    }

    public void inserisciCollegamento(Citta citta) {
        collegamenti.add(citta);
    }

    public int dislivello(int altezza) {
        return Math.abs(this.altezza - altezza);
    }

}
