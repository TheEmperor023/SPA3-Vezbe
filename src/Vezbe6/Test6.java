package Vezbe6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test6 {
    public static void main(String[] args) throws IOException{
        TreeMap<Tablica, String> map = readTree("files/kola1.txt");
        System.out.println(map.height());
        System.out.println(map.size());
        map.balanceIfNeeded();
        System.out.println(map.height());
        System.out.println(map.size());
    }

    public static TreeMap<Tablica, String> readTree(String fileName) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        TreeMap<Tablica, String> toRet = new TreeMap();
        String line = bf.readLine();
        while (line != null){
            String[] tokens = line.split(";");
            Tablica tab = new Tablica(tokens[0]);
            String vlasnik = tokens[1];
            toRet.put(tab, vlasnik);
            line = bf.readLine();
        }
        return toRet;
    }
}


