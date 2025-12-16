class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indegree = new int[numCourses];
        for(ArrayList<Integer> list : adj){
            for(int vx : list) indegree[vx]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0 ) q.offer(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int vx : adj.get(curr)) {
                indegree[vx]--;
                if(indegree[vx] == 0) q.offer(vx);
            }
            topo.add(curr);
        }
        if(topo.size() != numCourses) return new int[0];
        int[] ans = new int[topo.size()];
        for(int i  = 0 ; i < ans.length ; i++) ans[i] = topo.get(i);
        return ans;
    }
}