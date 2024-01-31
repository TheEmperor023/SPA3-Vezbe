package Vezbe6;

import java.security.Key;
import java.util.*;

public class TreeMap<K extends Comparable<K>, V>{

    private TreeNode root;

    private class TreeNode {
        K key;
        V value;

        TreeNode left, right;
        int N;

        TreeNode(K key, V value, int N){
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            return root.N;
        }
    }

    public V get(K key){
        return get(root, key);
    }

    private V get(TreeNode x, K key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }

    private TreeNode put(TreeNode x, K key, V value) {
        if(x == null) return new TreeNode(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean contains(K key){
        return get(key) != null;
    }

    public K minKey(){
        TreeNode curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.key;
    }

    public K maxKey(){
        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.key;
    }

    public List<K> keysInRange(K a, K b){
        Queue<K> queue = new LinkedList<>();
        keysInRange(root, queue, a, b);
        return new ArrayList<>(queue);
    }

    private void keysInRange(TreeNode x, Queue<K> queue, K a, K b) {
        if (x == null) return;
        int cmpa = a.compareTo(x.key);
        int cmpb = b.compareTo(x.key);
        if(cmpa < 0) keysInRange(x.left, queue, a, b);
        if(cmpa <= 0 && cmpb >= 0) queue.add(x.key);
        if(cmpb < 0) keysInRange(x.right, queue, a, b);
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode x) {
        if (x == null)
            return 0;
        int leftH = height(x.left);
        int rightH = height(x.right);
        return Math.max(leftH, rightH) + 1;
    }

    public void balanceIfNeeded(){
        int heightDiff = height(root.left) - height(root.right);
        heightDiff = Math.abs(heightDiff);
        if (heightDiff > 3) {
            System.out.println("No need for balancing!");
            return;
        }
        System.out.println("Balancing...");
        ArrayList<Pair<K, V>> elems = formArray(root, new ArrayList<Pair<K, V>>());
        root = build(elems, 0, elems.size() - 1);
    }

    private TreeNode build(ArrayList<Pair<K,V>> elems, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Pair<K, V> curr = elems.get(mid);
        TreeNode node = new TreeNode(curr.key, curr.value, 1);
        node.left = build(elems, start, mid - 1);
        node.right = build(elems, mid + 1, end);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    class Pair<K, V>{
        K key;
        V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    public ArrayList<Pair<K,V>> formArray(TreeNode root, ArrayList<Pair<K,V>> arr){
        if (root == null) return arr;
        arr = formArray(root.left, arr);
        arr.add(new Pair<>(root.key, root.value));
        arr = formArray(root.right, arr);
        return arr;
    }

}
