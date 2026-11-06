class Solution {
    public int longestCycle(int[] edges) {
        boolean[] visit = new boolean[edges.length];
        int maxi = -1;
        for(int i = 0 ; i < edges.length ; i++){
            if(visit[i]) continue;
            Map<Integer , Integer> map = new HashMap<>();
            for(int j = i , d = 0 ; j != -1 ; j = edges[j]){
                if(map.containsKey(j)){
                    maxi = Math.max(maxi , d - map.get(j));
                    break;
                }
                if(visit[j]) break;
                visit[j] = true;
                map.put(j , d++);
            }
        }
        return maxi;
    }
}