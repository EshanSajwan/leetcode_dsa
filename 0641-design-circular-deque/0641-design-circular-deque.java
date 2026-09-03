class MyCircularDeque {
    class Node{
        int val ;
        Node left , right;
        Node(int x ){
            this.val = x;
        }
    }
    Node head , tail;
    int size , capacity;

    public MyCircularDeque(int k) {
        head = tail = null;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size == capacity) return false;
        Node newNode = new Node( value );
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            head.left = newNode;
            newNode.right = head;
            head = newNode;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        Node newNode = new Node( value );
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        if(size == 1){
            head = tail = null;
        }
        else{
            head = head.right;
            head.left = null;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        if(size == 1){
            head = tail = null;
        }
        else{
            tail = tail.left;
            tail.right = null;
        }
        size--;
        return true;        
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return head.val;
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */