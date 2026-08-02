class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int teemo = 0 , res = 0;
        for(int i = 0 ; i < timeSeries.length ; i++){
            int curr = timeSeries[i];
            if(curr == teemo){
                res += duration - 1;
                teemo += duration - 1;
            }
            else if(curr < teemo){
                int end = curr + duration - 1;
                res += Math.max( end - teemo , 0);
                teemo = Math.max(teemo , end);
            }
            else{
                res += duration;
                teemo = curr + duration - 1;
            }
        }
        return res;
    }
}