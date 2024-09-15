package clone_graph_133;

import java.util.*;

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> nodesByValues = new HashMap<>();

        return cloneGraphDFS(node, nodesByValues);
    }

    private Node cloneGraphBFS(Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        Map<Integer, Node> nodesByValues = new HashMap<>();

        queue.addLast(node);
        nodesByValues.put(node.val, new Node(node.val));

        while (! queue.isEmpty()) {
            var current = queue.removeFirst();
            var clone = nodesByValues.get(current.val);

            for (Node neighbour : current.neighbors) {
                var neighbourClone = nodesByValues.get(neighbour.val);
                if (neighbourClone == null) {
                    neighbourClone = new Node(neighbour.val);
                    nodesByValues.put(neighbourClone.val, neighbourClone);

                    queue.addLast(neighbour);
                }

                clone.neighbors.add(neighbourClone);
            }
        }

        return nodesByValues.get(node.val);
    }

    private Node cloneGraphDFS(Node node, Map<Integer, Node> nodesByValues) {
        if (nodesByValues.containsKey(node.val)) return nodesByValues.get(node.val);

        Node clone = new Node(node.val);
        nodesByValues.put(clone.val, clone);

        for (Node neighbour : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbour, nodesByValues));
        }

        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}