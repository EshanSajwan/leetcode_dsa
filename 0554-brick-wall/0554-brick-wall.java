class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int cuts = wall.size(); 
        List<Set<Integer>> al = new ArrayList<>();
        int n = wall.size();
        for(int i = 0 ; i < n ; i++){
            al.add(new HashSet<>());
        }
        Map<Integer , Integer> availableCuts = new HashMap<>();
        int len = 0;
        for(int x : wall.get(0)) len += x;
        for(int i = 0 ; i < n ; i++){
            int curr = 0;
            for(int w : wall.get(i)){
                curr += w;
                if(curr == len) continue;
                availableCuts.put(curr , 0);
                al.get(i).add(curr);
            }
        }
        for(int key : availableCuts.keySet()){
            int res = 0;
            for(Set<Integer> set : al){
                if(set.contains(key)) res++;
            }
            cuts = Math.min( cuts , n - res);
        }
        return cuts;
    }
}