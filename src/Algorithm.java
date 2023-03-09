import helpers.Point;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Algorithm {
    //private Maze maze;
    private Set closedSet;
    private Set openSet;
    //methods: f, g, h, getLowest,
    private Tree navigated;

    public Algorithm(Maze m) {
        closedSet = new HashSet();
        openSet = new HashSet(m.initial);
        navigated = new TreeMap();
    }

    private class Tree<T> {
        private Node<T> root;

        private Tree(T rootData) {
            root = new Node<T>();
            root.data = rootData;
            root.parent = null;
            root.children = new ArrayList<Node<T>>();
        }

        private static class Node<T> {
            private T data;
            private Node<T> parent;
            private List<Node<T>> children;
        }
    }
}
