class Solution {
    public long smallestNumber(long num) {
        int[] freq = new int[10];
        boolean flag = num >= 0;
        if(!flag) num = -num;
        while(num != 0){
            freq[(int)(num % 10)]++;
            num /= 10;
        } 
        long res = 0;
        if(flag){
            if(freq[0] > 0){
                for(int i = 1 ; i < 10 ; i++) {
                    if(freq[i] > 0){
                        res = i;
                        freq[i]--;
                        break;
                    }
                }
                while(freq[0] > 0){
                    res = res * 10 ;
                    freq[0]--;
                }
            }
            for(int i = 1; i < 10 ; i++){
                for(int j = 0 ; j < freq[i] ; j++) res = res * 10 + i;
            }
            return res;
        }
        else{
            for(int i = 9 ; i > -1 ; i--){
                for(int j = 0 ; j < freq[i] ; j++) res = res * 10 + i ;
            }
            return -res;
        }
    }
}