package Vezbe8;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Imenik {
    private TreeMap<String, String> imenik;
    private HashMap<String, String> brojnik;

    public Imenik(){
        imenik = new TreeMap<>();
        brojnik = new HashMap<>();
    }

    public String getTel(String osoba){
        return imenik.get(osoba);
    }

    public String getOsoba(String tel){
        return brojnik.get(tel);
    }

    public boolean put(String osoba, String tel){
        if(imenik.containsKey(osoba) || brojnik.containsKey(tel)){
            return false;
        } else {
            imenik.put(osoba, tel);
            brojnik.put(tel, osoba);
            return true;
        }
    }

    public Set<String> getBrojevi(){
        return brojnik.keySet();
    }

    public List<String> getOsobe(){
        return imenik.navigableKeySet().stream().toList();
    }

    public void ucitaj(String file){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("files/foni.txt"));
            String line = bf.readLine();
            while(line != null){
                String[] tokens = line.split(";");
                put(tokens[0],tokens[1]);
                line = bf.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
