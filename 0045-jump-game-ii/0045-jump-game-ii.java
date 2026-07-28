class Solution {
    public int jump(int[] nums) {
        // range range khelunga
        // ek particular point se me min to max kis range tak ja paunga 
        int l = 0 , r = 0 , jumps = 0;
        while(r < nums.length -1){
            int maxR = r;
            for(int x = l ; x <= r ;x++){
                int curr = nums[x];
                maxR = Math.max( maxR , x + curr );
            }
            l = r + 1;
            r = maxR;
            jumps++;
        }
        return jumps;
    }
}