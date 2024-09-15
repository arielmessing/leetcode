package prefix_tree_trie_impl_208;

import java.util.Optional;

class Trie {

    final private Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = indexOf(c);

            if (current.children[index] == null)
                current.children[index] = new Node(c);

            current = current.children[index];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        Optional<Node> result = getNodeFor(word);
        return (result.isPresent() && result.get().isWord);
    }
    
    public boolean startsWith(String prefix) {
        Optional<Node> result = getNodeFor(prefix);
        return result.isPresent();
    }

    private int indexOf(char c) {
        return c - 'a';
    }

    private Optional<Node> getNodeFor(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = indexOf(c);

            if (current.children[index] == null) return Optional.empty();

            current = current.children[index];
        }

        return Optional.of(current);
    }

    static class Node {
        char value;
        boolean isWord;
        Node[] children;

        public Node(char value) {
            this.value = value;
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */