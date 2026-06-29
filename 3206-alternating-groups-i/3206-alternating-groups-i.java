class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length , count = 0;
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                if(checker(colors , n - 1 , i , i + 1)) count++;
            }
            else if(i == n - 1){
                if(checker(colors , i - 1 , i , 0)) count++;
            }
            else{
                if(checker(colors , i - 1 , i , i + 1)) count++;
            }
        }
        return count;
    }
    private boolean checker(int[] colors , int l , int mid , int r){
        if(colors[mid] == 1){
            if(colors[l] == 1 || colors[r] == 1) return false;
        }
        else{
            if(colors[l] == 0 || colors[r] == 0) return false;
        }
        return true;
    }
}