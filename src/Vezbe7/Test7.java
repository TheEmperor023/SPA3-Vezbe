package Vezbe7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test7 {
    public static void main(String[] args) throws IOException{
        TrieSet set = read("files/neka-imena.txt");
        System.out.println(set.listOfKeys());
        System.out.println(set.highestOccurrence());
        System.out.println(set.listWithPrefix("Ne"));
    }

    public static TrieSet read(String file) throws IOException{
        TrieSet toRet = new TrieSet();
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line = bf.readLine();
        while (line != null){
            toRet.put(line);
            line = bf.readLine();
        }
        return toRet;
    }
}
