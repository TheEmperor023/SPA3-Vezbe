package Vezbe2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class Test2 {
    public static void main(String[] args) {
        Digraph G = new Digraph(new In("files/digraf-konture.txt"));
        DirectedCycle cycle = new DirectedCycle(G);
        System.out.println("Ima konturu: " + cycle.hasCycle());
        System.out.println("Kontura:");
        System.out.println(cycle.cycle());
    }
}
