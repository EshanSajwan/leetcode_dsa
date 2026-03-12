class Solution{
    class pair{
        int node , time;
        pair(int x , int y){
            this.node = x;
            this.time = y;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++) graph.add(new ArrayList<>());
        for(int[] time : times) {
            graph.get(time[0]).add(new pair(time[1] , time[2]));
        }
        int[] timer = new int[n + 1];
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> {
               return a.time - b.time;
            }
        );
        Arrays.fill(timer , (int)1e9);
        pq.offer(new pair(k , 0));
        timer[k] = 0;

        while(!pq.isEmpty()){
            pair curr = pq.poll();

            for(pair vx : graph.get(curr.node)){
                int pre = timer[vx.node];
                timer[vx.node] = Math.min( timer[vx.node] , timer[curr.node] + vx.time);
                if(timer[vx.node] < pre) pq.offer(new pair(vx.node , timer[vx.node]));
            }
        }
        for(int i = 1 ; i< n+1 ; i++) if(timer[i] == (int)1e9) return -1;
        int max = -1;
        timer[0] = -1;
        for(int i : timer) max = Math.max(max , i);
        return max != 0 ? max : -1;
    }
}