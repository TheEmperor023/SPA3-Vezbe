package Vezbe4;

import edu.princeton.cs.algs4.*;

import java.util.Collection;
import java.util.Iterator;

public class LightestPath {
    private EdgeWeightedGraph G;
    private double weight;

    private Iterable<Edge> path;



    public LightestPath(EdgeWeightedGraph G){
        this.G = G;
    }

    public void findPath(int v, int w){
        DijkstraUndirectedSP dijkstraSP = new DijkstraUndirectedSP(G, v);
        weight = dijkstraSP.distTo(w);
        path = dijkstraSP.pathTo(w);
    }

    public double getWeight() {
        return weight;
    }

    public Iterable<Edge> getPath() {
        return path;
    }


}
