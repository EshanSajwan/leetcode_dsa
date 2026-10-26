class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // max window for true having at most k F
        int tw = 0, fw = 0 , fc = 0 , tc = 0 , i = 0 , j = 0;
        while(j < answerKey.length()){
            if(answerKey.charAt(j) == 'F') fc++;
            while(fc > k){
                if(answerKey.charAt(i++) == 'F') fc--;
            }
            tw = Math.max(tw , j++ - i + 1);
        }
        i = 0 ; j = 0;
        while(j < answerKey.length()){
            if(answerKey.charAt(j) == 'T') tc++;
            while(tc > k){
                if(answerKey.charAt(i++) == 'T') tc--;
            }
            fw = Math.max(fw , j++ - i + 1);
        }
        return Math.max(tw , fw);
    }
}