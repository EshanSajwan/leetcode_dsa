class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxDuuri = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a , b) -> Integer.compare(b , a));
        int i = 0 , stopsCount = 0;
        while( maxDuuri < target){
            while(i < stations.length && stations[i][0] <= maxDuuri)
                pq.offer(stations[i++][1]);
            if(pq.isEmpty()) return -1;
            maxDuuri += pq.poll();
            stopsCount++;
        }
        return stopsCount;
    }
}