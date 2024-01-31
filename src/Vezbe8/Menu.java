package Vezbe8;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Node root;
    private static class Node{
        private char id;
        private String name;
        private String command;

        private List<Node> children;

        public Node(char id, String name){
            this(id, name, null);

        }

        public Node(char id, String name, String command){
            this.id = id;
            this.name = name;
            this.command = command;
            this.children = new ArrayList<>();
        }

        public void addChildren(List<Node> children){
            this.children.addAll(children);

        }

    }

    public Menu(){
        root = new Node('~', "");
        List<Node> toAdd = new ArrayList<>();
        toAdd.add(new Node('f', "File"));
        toAdd.add(new Node('e', "Edit"));
        toAdd.add(new Node('p', "Play"));
        toAdd.add(new Node('z', "Zemlje"));
        root.addChildren(toAdd);
        Node file = root.children.get(0);
        toAdd.clear();
        toAdd.add(new Node('n', "new", "novi fajl"));
        file.addChildren(toAdd);
        toAdd.clear();
        Node edit = root.children.get(1);
        toAdd.add(new Node('c', "copy", "kopiram"));
        toAdd.add(new Node('x', "cut", "secem"));
        toAdd.add(new Node('v', "paste", "lepim"));
        toAdd.add(new Node('i', "indent"));
        toAdd.add(new Node('d', "delete"));
        edit.addChildren(toAdd);
    }

    private Node rootOfSubtree(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char currC = s.charAt(i);
            boolean changed = false;
            for (Node n:
                 curr.children) {
                if (currC == n.id){
                    curr = n;
                    changed = true;
                }
            }
            if(!changed){
                return null;
            }
        }
        return curr;
    }

    public void ispisi(String s){
        Node root = rootOfSubtree(s);
        if (root != null){
            printTree(root, 0);
        }
    }

    public static void printTree(Node node, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }
        sb.append(node.name);
        if(node.command != null){
            sb.append(" -> ");
            sb.append(node.command);
        }
        System.out.println(sb.toString());
        for (Node child : node.children) {
            printTree(child, level + 1);
        }
    }


}
