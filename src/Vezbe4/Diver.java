package Vezbe4;

import edu.princeton.cs.algs4.EdgeWeightedGraph;

public class Diver {

    private EdgeWeightedGraph G;
    private double capacity;

    public Diver(EdgeWeightedGraph G, double capacity){
        this.G = G;
    }

    public boolean canDive(int v, int w){
        LightestPath lightestPath = new LightestPath(G);
        lightestPath.findPath(v,w);
        return lightestPath.getWeight() < capacity;
    }
}
