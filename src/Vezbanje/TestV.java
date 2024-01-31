package Vezbanje;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class TestV {
    public static void main(String[] args) {
        Graph G = new Graph(new In("files/tinyG.txt"));
        TwoColorable tc = new TwoColorable(G);
        Cycle c = new Cycle(G);
        System.out.println("Is bipartate: " + tc.isBipartite());
        System.out.println("Has cycle: " + c.hasCycle());
    }
}
