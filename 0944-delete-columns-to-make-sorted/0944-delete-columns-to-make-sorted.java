class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length() , count = 0;
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < strs.length -1; i++){
                if(strs[i].charAt(j) > strs[i + 1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}