package Vezbe4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

import java.util.ArrayList;

public class LightestPaths {
    EdgeWeightedGraph G;

    ArrayList<Iterable<Edge>> paths;

    public LightestPaths(EdgeWeightedGraph G, int sink){
        this.G = G;
        findPaths(sink);
    }

    private void findPaths(int sink){
        LightestPath lightestPath = new LightestPath(G);
        for (int v = 0; v < G.V(); v++) {
            if (v == sink)
                continue;
            lightestPath.findPath(v, sink);
            paths.add(lightestPath.getPath());
        }
    }
}
