class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int x = 1 ,len = 1;
        for(int i = 0 ; i < k ; i++){
            if(x % k == 0){
                return len;
            }
        
            x = x * 10 + 1;
            x %= k;
            len++;
        }
        return -1;
    }
    
}