package Vezbe1;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) throws IOException {
        Graph g = new Graph();
        g.readGraph("files/tinyG.txt");
        System.out.println(g.neighbourList);
        HashSet<Integer> visited = new HashSet<>();
        g.DFS(8,visited);
        System.out.println(visited);
        System.out.println(g.components());
        System.out.println(g.pathDFS(1,5));
    }
}
