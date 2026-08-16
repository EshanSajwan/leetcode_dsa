class LFUCache {

    class dll{
        int key , value , level;
        dll next , prev , tail;
        dll(int key , int value , int level){
            this.key = key;
            this.value = value;
            this.level = level;
        }
    }
    Map<Integer , dll> map , freqMap;
    int capacity , leastFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        leastFreq = 1;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        upgrade(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            upgrade(map.get(key));
            map.get(key).value = value;
            return;
        }
        else if(map.size() == capacity){
            int removing = freqMap.get(leastFreq).tail.prev.key;
            delete(freqMap.get(leastFreq).tail.prev);
            map.remove(removing);
        }
        dll newNode = new dll(key , value , 1);
        if(!freqMap.containsKey(1)){
            insertLevel(1);
        } 
        insert(newNode , freqMap.get(1));
        leastFreq = 1;
        map.put(key , newNode);
    }

    private void upgrade(dll node){
        int currLvl = node.level;
        delete(node);
        if(!freqMap.containsKey(currLvl + 1)){
            insertLevel(currLvl + 1);
        } 
        insert(node , freqMap.get(currLvl + 1));
        node.level = currLvl + 1;
        if(currLvl == leastFreq && freqMap.get(currLvl).next.next == null)
            leastFreq = currLvl + 1;
    }
    private void insertLevel(int lvl){
        freqMap.put(lvl , createList());
    }
    private dll createList(){
        dll head = new dll(-1 , -1 , -1);
        dll tail = new dll(-1 , -1 , -1);
        head.next = tail;
        tail.prev = head;
        head.tail = tail;
        return head;
    }
    private void delete(dll node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    private void insert(dll node , dll head){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */