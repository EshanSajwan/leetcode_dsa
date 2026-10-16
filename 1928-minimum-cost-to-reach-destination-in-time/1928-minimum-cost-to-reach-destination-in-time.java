class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        int n = passingFees.length;
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            List<Integer> li = new ArrayList<>();
            li.add(e[1]);li.add(e[2]);
            adj.get(e[0]).add(li);
            li = new ArrayList<>();
            li.add(e[0]);li.add(e[2]);
            adj.get(e[1]).add(li);
        }
        int[][] minCostCounter = new int[n][maxTime + 1];
        for(int i = 0 ; i < n ; i++)
        Arrays.fill(minCostCounter[i] , Integer.MAX_VALUE);
        // stucture -> {node , cost , time }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        minCostCounter[0][0] = passingFees[0];
        pq.offer(new int[]{0 , passingFees[0] , 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == n - 1) return curr[1];
            int currCost = curr[1], currTime = curr[2];
            for(List<Integer> li : adj.get(curr[0])){
                int node = li.get(0) , newTime = currTime + li.get(1);
                if(newTime <= maxTime && 
                minCostCounter[node][newTime] > currCost + passingFees[node])
                {
                    minCostCounter[node][newTime] =
                                        currCost + passingFees[node];
                    pq.offer(new int[]{         node ,
                                        currCost + passingFees[node],
                                                newTime });
                }
            }
        }
        return -1;
    }
}