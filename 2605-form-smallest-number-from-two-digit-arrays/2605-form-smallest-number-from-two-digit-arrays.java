class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] nums1Dig = new int[10] , nums2Dig = new int[10];
        for(int i = 0 ; i < nums1.length ; i++) nums1Dig[nums1[i]] = 1;
        for(int i = 0 ; i < nums2.length ; i++) nums2Dig[nums2[i]] = 1;
        int a = -1 , b = -1;
        for(int i = 1 ; i < 10 ; i++) {
            if(nums1Dig[i] == 1 && nums2Dig[i] == 1) return i;
            if(nums1Dig[i] == 1 && a == -1) a = i;
            if(nums2Dig[i] == 1 && b == -1) b = i;
        }
        return Math.min( a * 10 + b  , b * 10 + a);
    }
}