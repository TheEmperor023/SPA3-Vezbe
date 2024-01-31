package Vezbe4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

public class DiverWithRecharge {
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    private double capacity;

    public DiverWithRecharge(EdgeWeightedGraph G, double capacity, int s, int end){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        boolean reached = false;
        while (!pq.isEmpty() && !reached){
            int deQ = pq.delMin();
            reached = deQ == end;
            relax(G, deQ);
        }
    }

    private void relax(EdgeWeightedGraph G, int v)
    {
        for(Edge e : G.adj(v))
        {
            int w = e.other(v);
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }



}
