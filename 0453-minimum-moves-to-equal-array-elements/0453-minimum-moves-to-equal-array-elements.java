class Solution {
    public int minMoves(int[] nums) {
        int maxOp = 0 , minEl = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i < minEl) minEl = i;
        }
        for(int i : nums) maxOp += i - minEl;
        return maxOp;
    }
}
        
//         while(true){
//             int op = 0 , newMax = maxEl;
//             for(int i = 0 ; i < nums.length ; i++){
//                 if(maxEl != nums[i]){
//                     nums[i]++;
//                     op++;
//                     if(nums[i] > maxEl) newMax = nums[i];
//                 }
//             }
//             if(op == 0) break;
//             maxEl = newMax;
//             maxOp += op;
//         }
//         return maxOp;
//     }
// }