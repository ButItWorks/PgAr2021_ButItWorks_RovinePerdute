import java.util.ArrayList;

public class CittaXml {
    private int id;
    private String name;
    private String x;
    private String y;
    private String h;

    private ArrayList<Integer> collegamenti = new ArrayList<>();

    public CittaXml() {
        super();
    }

    public CittaXml(int id, String name, String x, String y, String h, ArrayList<Integer> collegamenti) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.h = h;
        this.collegamenti = collegamenti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public ArrayList<Integer> getCollegamenti() {
        return collegamenti;
    }

    public void setCollegamenti(ArrayList<Integer> collegamenti) {
        this.collegamenti = collegamenti;
    }

    public void inserisciCollegamento(int collegamento) {
        this.collegamenti.add(collegamento);
    }
}
