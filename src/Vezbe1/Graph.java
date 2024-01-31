package Vezbe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph<T> {
    HashMap<Integer, Set<Vertex>> neighbourList = new HashMap<>();
    LinkedList<Edge> edges = new LinkedList<>();

    public void readGraph(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int noOfV = Integer.parseInt(reader.readLine());
        for (int i = 0; i < noOfV; i++) {
            neighbourList.put(i, new HashSet<Vertex>());
        }
        System.out.println(neighbourList);
        String line = reader.readLine();
        line = reader.readLine();
        while (line != null){
            String[] tokens = line.split(" ");
            if(tokens.length != 2)
                continue;
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);
            Set<Vertex> v1neigh = neighbourList.get(v1);
            v1neigh.add(new Vertex(v2));
            Set<Vertex> v2neigh = neighbourList.get(v2);
            v2neigh.add(new Vertex(v1));
//            edges.add(new Edge(v1,v2));
            line = reader.readLine();
        }
    }

    int V(){
        return neighbourList.keySet().size();
    }

    int E() {
        return edges.size();
    }

    void addEdge(Vertex v1, Vertex v2){
        neighbourList.get(v1).add(v2);
        neighbourList.get(v2).add(v1);
        edges.add(new Edge(v1, v2));
    }

    Set<Vertex> adj(int v){
        return neighbourList.get(v);
    }

    void addVertex(int v){
        neighbourList.put(v, new HashSet<Vertex>());
    }

    void DFS(int start, Set<Integer> visited){
        for (Vertex v:
             adj(start)) {
            if(visited.contains(v.infor)){
                continue;
            }
            visited.add(v.infor);
            DFS(v.infor, visited);
        }
    }

    Set<Set<Integer>> components(){
        Set<Set<Integer>> toRet = new HashSet<Set<Integer>>();
        for (int i:
                neighbourList.keySet()) {
            HashSet<Integer> visited = new HashSet<>();
            DFS(i, visited);
            toRet.add(visited);
        }
        return toRet;
    }

    boolean DFSFinder(int curr, int end, Set<Integer> visited, List<Integer> path){
        visited.add(curr);
        path.add(curr);

        if(curr == end){
            return true;
        }

        for (Vertex v:
             adj(curr)) {
            if (!visited.contains(v.infor) && DFSFinder(v.infor, end, visited, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    List<Integer> pathDFS(int start, int end){
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        if (DFSFinder(start, end, visited, path)) {
            return path;
        } else {
            return Collections.emptyList();
        }

    }

}
