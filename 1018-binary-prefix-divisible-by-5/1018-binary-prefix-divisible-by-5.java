class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        long x = 0;
        for(int i : nums) {
            x = 2 * x + i;
            list.add(x % 5 == 0);
            x%=5;
        }
        return list;
    }
}