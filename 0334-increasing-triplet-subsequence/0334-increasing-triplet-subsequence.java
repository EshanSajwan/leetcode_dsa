class Solution {
    public boolean increasingTriplet(int[] nums) {
        int f = Integer.MAX_VALUE , s = Integer.MAX_VALUE;
        for(int t : nums){
            if(t <= f) f = t;
            else if( t <= s) s = t;
            else return true;
        }
        return false;
    }
}