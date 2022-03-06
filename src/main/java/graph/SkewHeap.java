package graph;

import java.util.ArrayList;
import java.util.List;

public class SkewHeap {
    private List<Integer> list = new ArrayList<>();

    private Node root;
    private int size;

    public SkewHeap() {
        this.size = 0;
        this.root = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        root = merge(root, newNode);
        ++size;
    }

    public int removeMin() throws EmptyHeapException {
        if (root == null) {
            throw new EmptyHeapException("Error! empty SkewHeap");
        }
        int val = root.value;
        root = merge(root.left, root.right);
        --size;
        return val;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void merge(SkewHeap other) {
        if (other != null) {
            root = merge(root, other.root);
            size = size + other.size;
            other.root = null;
            other.size = 0;
        }
    }

    private Node merge(Node x, Node y) {
        if (x == null)
            return y;
        if (y == null)
            return x;

        if (x.value < y.value) {
            Node temp = x.left;
            x.left = merge(x.right, y);
            x.right = temp;
            return x;
        }
        else {
            Node temp = y.right;
            y.right = merge(y.left, x);
            y.left = temp;
            return y;
        }
    }

    public List<Integer> displayHeap() {
        return display(this.root);
    }

    private List<Integer> display(Node r) {
        if (r != null) {
            display(r.left);
            list.add(r.value);
            display(r.right);
        }
        return list;
    }
}
