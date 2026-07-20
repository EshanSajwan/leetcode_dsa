class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int boxAt = -1 , cap = 101;
        for(int i = 0 ; i < capacity.length ; i++){
            if(capacity[i] >= itemSize && capacity[i] < cap){
                cap = capacity[i];
                boxAt = i;
            }
        }
        return boxAt;
    }
}