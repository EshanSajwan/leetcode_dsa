class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int[] dp1 = new int[arr.length];
        dp1[0] = 1;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i-1] < arr[i]) dp1[i] = dp1[i-1] +1;
            else dp1[i] = 1;
        }
        int[] dp2 = new int[arr.length];
        dp2[arr.length -1] = 1;
        for(int i = arr.length-2 ; i > -1 ; i--){
            if(arr[i+1] < arr[i]) dp2[i] = dp2[i+1] +1;
            else dp2[i] = 1;
        }

        int maxi = 0;
        for(int i = 0 ; i < arr.length ; i++){
          if(dp1[i] > 1 && dp2[i] > 1 ) maxi = Math.max(maxi , dp1[i] + dp2[i] -1);
        }
        return maxi != 1 ? maxi : 0;
    }
}