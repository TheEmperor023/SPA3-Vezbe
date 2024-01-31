package Vezbe4;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Edge;

public class DijkstraND {
    private double distTo[];
    private Edge edgeTo[];
    private IndexMinPQ<Double> pq;

    public DijkstraND(EdgeWeightedGraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedGraph G, int v) {
        for (Edge e:
             G.adj(v)) {
            int w = e.other(v);
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v] != Double.POSITIVE_INFINITY;
    }
}
