class Solution {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer , Integer> map = new HashMap<>(); 
        for(int i : arr) map.put(i , map.getOrDefault(i , 0) + 1);
        int[] occ = new int[1001];
        for(int val : map.values()){
            if(occ[val] != 0) return false;
            occ[val] = 1;
        }
        return true;
    }
}