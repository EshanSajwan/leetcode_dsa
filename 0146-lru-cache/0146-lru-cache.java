class LRUCache {

    class dll{
        int key , value;
        dll next , prev;
        dll(int x , int y){
            this.key = x;
            this.value = y;
        }
    }
    Map<Integer , dll> map;
    int capacity;
    dll head , tail;

    public LRUCache(int capacity) {
        
        head = new dll(-1 , -1);
        tail = new dll(-1 , -1);
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        delete(map.get(key));
        insert(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
        }
        else if(map.size() == capacity){
            int removing = tail.prev.key;
            delete(tail.prev);
            map.remove(removing);
        }
        dll newNode = new dll(key , value);
        insert(newNode);
        map.put(key , newNode);
    }
    private void delete(dll node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    private void insert(dll node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */