class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for(int i : nums) if(i != 0) pq.offer(i);
        int count = 0 , op = 0 , n = nums.length;
        while(count != n && pq.size() != 0){
            count = 0;
            int min = pq.poll();
            op++;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] == 0){
                    count++;
                    continue;
                }
                nums[i] -= min;
                if(nums[i] == 0) count++;
            }
            while(!pq.isEmpty()) pq.poll();
            for(int i : nums) if(i != 0) pq.offer(i);
        }
        return op;
    }
}