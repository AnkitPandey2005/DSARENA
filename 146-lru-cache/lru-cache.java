class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        //constructor
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> m=new HashMap<>();

    public LRUCache(int capacity){
        cap=capacity; //yha ham man kr chl rhe h abhi map m koi node ni h 
        head.next=tail;
        tail.prev=head;
    }

    //THIS IS DLL IMPLEMENTATION
    private void addNode(Node newNode){
        Node temp=head.next;
        newNode.next=temp;
        newNode.prev=head;

        head.next=newNode;
        temp.prev=newNode;
    }

    private void deleteNode(Node delnode){
        Node prevv=delnode.prev;
        Node nextt=delnode.next;

        prevv.next=nextt;
        nextt.prev=prevv;
    }

    
    public int get(int key) {
        //CASE -1 :if key exist in the map
        if(m.containsKey(key)){
            Node resNode=m.get(key);
            int ans=resNode.val;

            //when i touched node ==> means i align in LRU recently used concept
            //i)remove the old mapping {mtlb ab aage peeche k connection set kroo}
            m.remove(key);   //HASHMAP
            //ii)move the node in the front =>delete =>front
            deleteNode(resNode); //LRU 
            addNode(resNode);
            //update mapping 
            m.put(key,head.next);
            return ans;
        }
        //CASE 2 :if the key is not found in the map
        return -1;
    }
    
    public void put(int key, int value) {
        //CASE 1 :if the key exist in the map
        if(m.containsKey(key)){
            Node curr=m.get(key);
            m.remove(key);
            deleteNode(curr);
        }
        //Aghr size tumhara means capacity full h 
        if(m.size()==cap){
            //i)last element means just before the tail
            m.remove(tail.prev.key); //old mapping
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        m.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */