class Solution {
    public int edgeScore(int[] edges) {
        // Map<Integer , Long> map = new HashMap<>();
        long[] map = new long[edges.length];
        int ans = -1 ; long maxi = 0;
        for(int i = 0 ; i < edges.length ; i++){
            int node = edges[i];
            // map.put(node , map.getOrDefault(node , 0L) + i);
            map[node] += i;
            if(map[node] > maxi){
                maxi = map[node];
                ans = node;
            }
            else if(map[node] == maxi){
                ans = Math.min(ans , node);
            }
        }
        return ans;
    }
}