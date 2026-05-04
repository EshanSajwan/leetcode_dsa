class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums) pq.offer(i);
        for(int i = 0 ; i < k; i++){
            int x = pq.poll();
            pq.offer(x + 1);
        }
        long ans = 1;
        while(!pq.isEmpty()) ans = (ans * pq.poll()) % (long)(1e9 + 7);
        return (int)(ans);
    }
}