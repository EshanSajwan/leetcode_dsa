class Solution {
    public int missingInteger(int[] nums) {
        int[] isPresent = new int[50 * 50 + 1];
        for(int i : nums) isPresent[i] = 1;
        int i = 0 , j = 0 , len = 0 , start = 0, sum = 0;
        while(j < nums.length){
            sum += nums[j];
            while(j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                sum += nums[j + 1];
                j++;
            }
            for(int x = sum ; x < 50 * 50 + 1 ; x++) if(isPresent[x] == 0) return x;
            // i = j + 1;
            // j = i;
        }
        // int 
        // for( i = start ; i < start + len ; i++){
        //     sum += nums[i];
        // }

        // for( i = sum ; i < 50 * 50 + 1 ; i++) if(isPresent[i] == 0) return i;
        return -1;
    }
}