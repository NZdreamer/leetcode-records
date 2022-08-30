import java.util.*;

class LFUCache {
    
    class Node {
        int key;
        int value;
        int counter;
        Node pre;
        Node next;
        
        public Node() {}
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.counter = 1;
        }
    }
    
    class DLinkedList {
        Node head;
        Node tail;
        int size;
        
        public DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }
        
        public void insertFirst(Node n) {
            size++;
            Node tmp = head.next;
            head.next = n;
            n.pre = head;
            n.next = tmp;
            tmp.pre = n;
        }
        
        public void delete(Node n) {
            size--;
            n.pre.next = n.next;
            n.next.pre = n.pre;
        }
        
        public int size() {
            return size;
        }
    }
    
    int cap;
    int size;
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DLinkedList> freqMap;
    int minFreq;

    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node n = nodeMap.get(key);
            updateFreq(n);
            return n.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node n = nodeMap.get(key);
            n.value = value;
            updateFreq(n);
        }
        else {
            Node n = new Node(key, value);
            if (size < cap) {                
                addNode(n);
            }
            else {
                DLinkedList l = freqMap.get(minFreq);
                if (l == null) return;
                Node lfu = l.tail.pre;
                l.delete(lfu);
                nodeMap.remove(lfu.key);
                addNode(n);
            }
        }
    }
    
    private void addNode(Node n) {
        size++;
        nodeMap.put(n.key, n);
        if (!freqMap.containsKey(1)) {
            freqMap.put(1, new DLinkedList());
        }
        DLinkedList l = freqMap.get(1);
        l.insertFirst(n);
        minFreq = 1;
    }
    
//     private void deleteNode(Node n) {
        
//     }
    
    private void updateFreq(Node n) {
        int f = n.counter;
        freqMap.get(f).delete(n);
        if (freqMap.get(f).size() == 0 && minFreq == f) {
            minFreq++;
        }
        n.counter++;
        f++;
        if (freqMap.containsKey(f)) {
            freqMap.get(f).insertFirst(n);
        }
        else {
            DLinkedList l = new DLinkedList();
            l.insertFirst(n);
            freqMap.put(f, l);
        }
    }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */