/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
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
*/

class Solution {
     Node[] nodes ;
     boolean visit[] ;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        nodes = new Node[101];
        visit = new boolean[101];
        dfs(node);
        Arrays.fill(visit , false);
        dfsAssign(node);
        return nodes[node.val];
    }
    void dfs(Node node){
        visit[node.val] = true;
        nodes[node.val] = new Node(node.val);
        for(Node vx : node.neighbors){
            if(!visit[vx.val]) dfs(vx);
        }
    }
    void dfsAssign(Node node){
        visit[node.val] = true;
        // nodes[node.val].val = node.val;
        for(Node vx : node.neighbors){
            nodes[node.val].neighbors.add(nodes[vx.val]);
        }
        for(Node vx : node.neighbors){
            if(!visit[vx.val]) dfsAssign(vx);
        }
    }
}