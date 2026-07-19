class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int i = Integer.MAX_VALUE , j = 0;
        for(int bloom : bloomDay){
            i = Math.min( i , bloom );
            j = Math.max( j , bloom );
        }
        int ans = -1;
        while(i <= j){
            int mid = i + (j - i) /2;
            if(madeBouquets(mid , bloomDay , m , k)){
                ans = mid;
                j = mid - 1;
            }
            else i = mid + 1;
        }
        return ans;
    }
    private boolean madeBouquets( int x , int[] bloomDay, int m, int k){
        int i = 0 , n = bloomDay.length;
        while(i <= n - k){
            if(bloomDay[i] <= x){
                boolean flag = true;
                for(int j = 1; j < k ; j++){
                    if(bloomDay[i + j] > x){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    m--;
                    if(m == 0) return true;
                    i += k;
                    continue;
                }
            }
            i++;
        }
        return m == 0;
    }
}