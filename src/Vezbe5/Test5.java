package Vezbe5;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.PrimMST;

public class Test5 {
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("files/neusm-t1.txt"));
        MST pokrivajuceStablo = new MST(G, 0);
        for (Edge e:
                pokrivajuceStablo.getTree().edges()) {
            System.out.println(e);
        }
        PrimMST test = new PrimMST(G);
        System.out.println(test.edges());
        MSTWithEdge withEdge = new MSTWithEdge(G, new Edge(0,2,1));
        for (Edge e:
                withEdge.getTree().edges()) {
            System.out.print(e + " ");
        }
    }
}
