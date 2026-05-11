class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum = 0 , singleDgSum = 0 , DblDgSum = 0;
        for(int i : nums) {
            sum += i;
            if(i < 10) singleDgSum += i;
            else DblDgSum += i;
        }
        
        return (singleDgSum > sum - singleDgSum) || (DblDgSum > sum - DblDgSum);
    }
}