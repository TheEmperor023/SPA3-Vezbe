package Vezbe1;

public class Edge {
    int weight;
    Vertex v1;
    Vertex v2;

    Edge(int w, Vertex v1, Vertex v2){
        this.weight = w;
        this.v1 = v1;
        this.v2 = v2;
    }

    Edge(Vertex v1, Vertex v2){
        this.weight = 1;
        this.v1 = v1;
        this.v2 = v2;
    }

}
