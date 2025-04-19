class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node (int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }
    
    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if (keyToNode.size() > capacity) {
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */