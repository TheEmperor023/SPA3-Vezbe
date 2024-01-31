package Vezbanje;

import edu.princeton.cs.algs4.Graph;

public class TwoColorable {
    boolean[] marked;
    boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColorable(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            dfs(G, v);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w:
             G.adj(v)) {
            if (!marked[w]) {
                color[v] = !color[w];
                dfs(G, w);
            }else if(color[v] == color[w])
                isTwoColorable = false;
        }
    }

    public boolean isBipartite(){
        return isTwoColorable;
    }
}
