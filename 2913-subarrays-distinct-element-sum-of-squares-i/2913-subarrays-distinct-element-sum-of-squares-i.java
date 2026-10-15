class Solution {
    public int sumCounts(List<Integer> nums) {
        int[] freq = new int[101];
        int res = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            Arrays.fill(freq , 0);
            int count = 0;
            for(int j = i ; j < nums.size() ; j++){
                if(freq[nums.get(j)] == 0){
                    count++;
                }
                freq[nums.get(j)] = 1;
                res += count * count;
            }
        }
        return res;
    }
}