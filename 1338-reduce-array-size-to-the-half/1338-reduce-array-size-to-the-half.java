class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : arr) map.put( num , map.getOrDefault(num , 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        for(int val : map.values()) pq.offer(val);
        int removed = 0 , ans = 0;
        while(!pq.isEmpty()){
            removed += pq.poll();
            ans++;
            if(removed >= arr.length / 2) break;
        }
        return ans;            
    }
}