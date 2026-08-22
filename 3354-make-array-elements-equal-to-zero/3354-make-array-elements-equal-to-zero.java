class Solution {
    public int countValidSelections(int[] nums) {
        int res = 0;
        int[] preFix = new int[nums.length] , sufFix = new int[nums.length];
        int pre = 0 , suf = 0;
        for(int i = 0 ; i < nums.length ; i++){
            pre += nums[i];
            preFix[i] = pre;
            suf += nums[nums.length - i - 1];
            sufFix[nums.length - i - 1] = suf;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                int x = Math.abs(preFix[i] - sufFix[i]);
                if(x == 0) res += 2;
                else if(x == 1) res += 1;
            }
        }
        return res;
        // for(int i = 0 ; i < nums.length; i++){
        //     if(nums[i] == 0){
        //         int check[] = nums.clone();
        //         int x = i;
        //         if(x == 0 ){
        //             boolean right = true;
        //             while(x >= 0 && x <= nums.length - 1){
        //                 if(check[x] == 0){
        //                     if(right) x++;
        //                     else x--;
        //                 }
        //                 else{
        //                     check[x]--;
        //                     if(right){
        //                         x--;
        //                         right = false;
        //                     }
        //                     else{
        //                         x++;
        //                         right = true;
        //                     }
        //                 }
        //             } 
        //         }
        //         else{
        //             boolean right = false;
        //             while(x >= 0 && x <= nums.length - 1){
        //                 if(check[x] == 0){
        //                     if(right) x++;
        //                     else x--;
        //                 }
        //                 else{
        //                     check[x]--;
        //                     if(right){
        //                         x--;
        //                         right = false;
        //                     }
        //                     else{
        //                         x++;
        //                         right = true;
        //                     }
        //                 }
        //             }
        //         }
        //         boolean valid = true;
        //         for(int num : check) {
        //             if(num != 0){
        //                 valid = false;
        //                 break;
        //             }
        //         }
        //         if(valid) res += 2;
        //     }
        // }
        // return res;
    }
}