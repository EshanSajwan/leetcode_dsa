class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        int x = 1;
        for(int i = 1 ; i < n ; i++){
            if(ratings[i] > ratings[i - 1]) left[i] = ++x;
            else{
                left[i] = 1;
                x = 1;
            }
        }
        int sum = Math.max(left[n - 1] , 1);
         x = 1;
        for(int i = n - 2 ; i > -1 ; i--){
            if(ratings[i] > ratings[i + 1]){
                sum += Math.max( left[i] , ++x);
            }
            else{
                sum += Math.max( left[i] , 1);
                x = 1;
            }
        }
        return sum;
    }
}