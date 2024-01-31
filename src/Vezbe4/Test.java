package Vezbe4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;

public class Test {
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("files/neusm-t1.txt"));
//        HeaviestVertex heaviestVertex = new HeaviestVertex(G);
//        System.out.println("Najtezi cvor: " + heaviestVertex.getVertex());
//        System.out.println("Tezina: " + heaviestVertex.getWeight());
//        LightestVertex lightestVertex = new LightestVertex(G);
//        System.out.println("Najlaksi cvor: " + lightestVertex.getVertex());
//        System.out.println("Tezina: " + lightestVertex.getWeight());
//        LightestPath lightestPath = new LightestPath(G);
//        lightestPath.findPath(5,8);
//        System.out.println("Tezina puta: " + lightestPath.getWeight());
//        for (Edge e:
//             lightestPath.getPath()) {
//            System.out.println(e);
//        }
        DijkstraND dijkstra = new DijkstraND(G , 3);
        System.out.printf(dijkstra.distTo(8) + ", " + dijkstra.hasPathTo(7));

    }
}
