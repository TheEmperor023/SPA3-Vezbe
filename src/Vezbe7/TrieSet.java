package Vezbe7;

import Vezbe6.TreeMap;

import java.util.*;

public class TrieSet {
    private Node root;

    private static class Node{
        private int val;
        private TreeMap<Character, Node> next = new TreeMap<>();

        public Node(int val){
            this.val = val;
        }
    }

    public int get(String key){
        Node x = get(root, key, 0);
        if (x == null)
            return 0;
        return x.val;
    }

    private Node get(Node x, String key, int i) {
        if (x == null)
            return null;
        if (i == key.length())
            return x;
        char c = key.charAt(i);
        return get(x.next.get(c), key, i + 1);
    }

    public void put(String key){
        root = put(root, key, 0);
    }

    private Node put(Node x, String key, int i) {
        if (x == null) x = new Node(0);
        if (i == key.length()) { x.val = x.val + 1; return x; }
        char c = key.charAt(i);
        x.next.put(c, put(x.next.get(c), key, i+1));
        return x;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != 0) q.add(pre);
        for (char c = 0; c < 256; c++)
            collect(x.next.get(c), pre + c, q);
    }

    public void printKeysAndValues(){
        for (String s:
             keys()) {
            System.out.println(s + ": " + get(s));
        }
    }

    public List<String> listOfKeys(){
        ArrayList<String> toRet = new ArrayList<>();
        for (String s:
             keys()) {
            for (int i = 0; i < get(s); i++) {
                toRet.add(s);
            }
        }
        return toRet;
    }

    public Set<String> setOfKeys(){
        HashSet<String> toRet = new HashSet<>();
        for (String s:
             keys()) {
            toRet.add(s);
        }
        return toRet;
    }

    public List<String> highestOccurrence() {
        ArrayList<String> toRet = new ArrayList<>();
        int max = 0;
        for (String s:
             keys()) {
            if (get(s) > max){
                max = get(s);
            }
        }
        for (String s:
             keys()) {
            if(get(s) == max)
                toRet.add(s);
        }
        return toRet;
    }

    public List<String> listWithPrefix(String prefix){
        ArrayList<String> toRet = new ArrayList<>();
        for (String s:
             keysWithPrefix(prefix)) {
            toRet.add(s);
        }
        return toRet;
    }


    public void delete(String key){
        Node x = get(root, key, 0);
        if(x == null || x.val == 0){
            System.out.println("Kljuc ne postoji, brisanje nije moguce!");
        }
        x.val = x.val - 1;
    }


}
