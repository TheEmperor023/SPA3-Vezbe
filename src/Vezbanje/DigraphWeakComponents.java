package Vezbanje;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.Graph;

public class DigraphWeakComponents {
    private boolean marked[];
    private int id[];
    private int count;

    public DigraphWeakComponents(Digraph G){
        Graph GUnD = makeUndirected(G);
    }

    private Graph makeUndirected(Digraph g) {
        return null;
    }
}
