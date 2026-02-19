class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int f1 = 0 , f2 = 0 , k1 = 0 , k2 = 0;
        for(int i : nums){
            if(f1 == 0 && k2 != i ){
                f1++;
                k1 = i;
            }
            else if(f2 == 0 && k1 != i){
                f2++;
                k2 = i;
            }
            else if(i == k1) f1++;
            else if(i == k2) f2++;
            else{
                f1--; f2--;
            }
        }
        f1 = f2 = 0;
        for(int i : nums){
            if(i == k1) f1++;
            if(i == k2) f2++;
        }
        int n = nums.length / 3;
        if(f1 > n) list.add(k1);
        if(f2 > n && k2 != k1) list.add(k2);
        return list;
    }
}