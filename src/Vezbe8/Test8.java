package Vezbe8;

import java.io.BufferedReader;
import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
//        Imenik imenik = new Imenik();
//        imenik.ucitaj("files/foni.txt");
//        System.out.println(imenik.getOsobe());
//        System.out.println(imenik.getBrojevi());
        Menu m = new Menu();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line != ""){
            m.ispisi(line);
            line = scanner.nextLine();
        }
    }
}
