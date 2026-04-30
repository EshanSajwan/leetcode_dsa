class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> al = new ArrayList<>();
        for(int[] i : triplets){
            if(i[0] <= target[0] && i[1] <= target[1] && i[2] <= target[2]) al.add(i);
        }
        int a = -1 , b = -1 , c = -1;
        for(int i[] : al){
            if(i[0] <= target[0]) a = Math.max( a , i[0]);
            if(i[1] <= target[1]) b = Math.max( b , i[1]);
            if(i[2] <= target[2]) c = Math.max( c , i[2]);
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}