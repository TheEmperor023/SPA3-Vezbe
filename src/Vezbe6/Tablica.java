package Vezbe6;

public class Tablica implements Comparable<Tablica> {

    private String id;

    public Tablica(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Tablica o) {
        return id.compareTo(o.id);
    }
}
