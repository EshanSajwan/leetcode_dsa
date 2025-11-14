class Solution {
    public int maxArea(int[] h) {
       int ans = 0;
        int i = 0 , j = h.length -1;
        while(i < j){
           int height = Math.max(h[i] , h[j]) - Math.abs(h[i] - h[j]);
           ans = Math.max(ans , height * (j - i ));
           if(h[i] == h[j]){
            if(h[i+1] > h[j-1]) j--;
            else if(h[i+1] <= h[j-1]) i++;
           }
           else if(h[i] < h[j]) i++;
           else j--; 
        }
        return ans;
    }
}