class Solution {
    Set<Integer> visited ;
    public boolean canReach(int[] arr, int start) {
        visited = new HashSet<>();
        return rec(arr , start);
    }
    public boolean rec(int[] arr, int start) {
        if(arr[start] == 0) return true;
        visited.add(start);
        int n = arr.length;
        boolean aage = false , pichhe = false;
        // aage
        if(start + arr[start] < n && !visited.contains(start + arr[start]))
         aage = rec(arr , start + arr[start]);
        if(aage) return aage;
        // pichhe    
        if(start - arr[start] > -1 && !visited.contains(start - arr[start]))
         pichhe = rec(arr , start - arr[start]);
        return aage || pichhe;
    }
}