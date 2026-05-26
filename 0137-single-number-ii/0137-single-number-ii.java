class Solution {
    public int singleNumber(int[] nums) {
        int[] bittu = new int[32];
        for(int x : nums){
            long number = x;
            int pos = 31;
            if(x < 0) number = -number;
            while(number != 0){
                int bit = (int)(number & (long)1);
                number = number >> 1;
                bittu[pos--] += bit;
            }
        }
        int res = 0 , power = 0;
        // for(int i = 31 ; i > -1 ; i--){
        //     res += Math.pow(2 , power++) * (bittu[i] % 3); 
        // }
        for(int i = 0 ; i < 32 ; i++){
            if(bittu[i] % 3 == 1) res = res | (1 << 31 - i);
        }
        int freq = 0;
        for(int i : nums) if(i == res) freq++;
        if(freq ==  1) return res;
        return -res;
    }
}