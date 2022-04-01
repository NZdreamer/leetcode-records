class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;

    public DLinkedNode() {

    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private HashMap<Integer, DLinkedNode> cache = new HashMap();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedNode cur = cache.get(key);
            removeNode(cur);
            addNode(cur);
            return cur.value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        DLinkedNode target = new DLinkedNode(key, value);
        //System.out.println(target.value);
        if (cache.containsKey(key)) {
            DLinkedNode cur = cache.get(key);
            cache.put(key, target);
            removeNode(cur);
            addNode(target);

        }
        else {
            cache.put(key, target);
            addNode(target);
            count++;
            if (count > capacity) {
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */