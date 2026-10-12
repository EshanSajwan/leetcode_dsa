class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] q = new int[queries.length][2];
        for(int i = 0 ; i < queries.length ; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q , (a,b) -> Integer.compare(a[0] , b[0]));
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0] , b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
                                    Integer.compare(a[1] - a[0] , b[1] - b[0]));
        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] query : q){
            int point = query[0];
            while(i < intervals.length && intervals[i][0] <= point){
                pq.offer(new int[]{intervals[i][0] , intervals[i][1]});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < point) pq.poll();
            if(pq.isEmpty()){
                ans[query[1]] = -1;
            }
            else ans[query[1]] = pq.peek()[1] - pq.peek()[0] + 1;
        }
        return ans;
    }
}