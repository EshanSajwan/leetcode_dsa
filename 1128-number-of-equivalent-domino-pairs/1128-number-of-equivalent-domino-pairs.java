class Solution {
    record pair(int a , int b){}
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<pair , Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] d : dominoes){
            pair p = new pair(d[0] , d[1]);
            if(map.containsKey(p)) ans += map.get(p);
            if(d[0] != d[1]){
                pair q = new pair(d[1] , d[0]);
                if(map.containsKey(q)) ans += map.get(q);
            }
            map.put(p , map.getOrDefault(p , 0) + 1);
        }
        return ans;
    }
}