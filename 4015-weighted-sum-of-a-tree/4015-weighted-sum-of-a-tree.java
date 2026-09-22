class Solution {
    List<List<Integer>> graph;
    int h ;
    int[] nums;
    public long weightedSum(int[] parent, int[] nums) {
        this.nums = nums;
        graph = new ArrayList<>();
        for(int i = 0 ; i < parent.length ; i++) graph.add(new ArrayList<>());
        for(int i = 1 ; i < parent.length ; i++){
            graph.get(parent[i]).add(i);
        }
        h = findHeight(0);
        return findWeight(0 , 1);
    }
    private long findWeight(int i , int d){
        long wt = (long)nums[i] * ( h - d + 1 );
        for(int vx : graph.get(i)){
            wt += findWeight(vx , d + 1);
        }
        return wt;
    }
    private int findHeight(int i){
        if(graph.get(i).isEmpty()) return 1;
        int maxi = 0;
        for(int vx : graph.get(i)) maxi = Math.max( maxi , findHeight(vx) + 1);
        return maxi;
    }
}