class Solution {
    public int trap(int[] height) {
        int i = 1 , j = height.length - 2 ,
        lMax = height[0] , rMax = height[height.length - 1],
        ans = 0 ;
        while(i <= j){
            if(lMax <= rMax){
                ans += Math.max(0 , Math.min(lMax , rMax) - height[i]);
                lMax = Math.max( lMax , height[i]);
                i++;
            }
            else{
                ans += Math.max(0 , Math.min(lMax , rMax) - height[j]);
                rMax = Math.max( rMax , height[j] );
                j--;
            }
        }
        return ans;
    }
}