class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> pq = 
        new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) pq.offer(i);
        for(int i = 0 ; i < k ; i++){
            int val = pq.poll();
            score += val;
            pq.offer((val + 2) / 3 );
        }
        return score;
    }
}