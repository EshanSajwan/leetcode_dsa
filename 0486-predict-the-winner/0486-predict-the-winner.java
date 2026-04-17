class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(nums.length < 3) return true;
        return game(0 , nums.length - 1 , nums , 0 , 0 , 1);
    }
    private boolean game(int i , int j , int[] nums , long p1 , long p2 , int p){
        if( i > j ) return p1 >= p2;
        
        if(p == 1){
            return 
            game(i + 1 , j , nums , p1 + nums[i] , p2 , 2) ||
            game(i , j - 1 , nums , p1 + nums[j] , p2 , 2);
        }

        return 
            game(i + 1 , j , nums , p1 , p2 + nums[i] , 1) &&
            game(i , j - 1 , nums , p1 , p2 + nums[j] , 1);

    }
}