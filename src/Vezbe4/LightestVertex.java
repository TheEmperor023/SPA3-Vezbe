package Vezbe4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

public class LightestVertex {
    private EdgeWeightedGraph G;
    private int vertex = 0;
    private double weight = Double.POSITIVE_INFINITY;

    public LightestVertex(EdgeWeightedGraph G){
        this.G = G;
        calculate(G);
    }

    private void calculate(EdgeWeightedGraph G) {
        for (int v = 0; v < G.V(); v++) {
            double sum = 0;
            for (Edge e : G.adj(v)){
                sum += e.weight();
            }
            if (sum < weight){
                weight = sum;
                vertex = v;
            }
        }
    }

    public int getVertex() {
        return vertex;
    }

    public double getWeight() {
        return weight;
    }
}
