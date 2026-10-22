class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0 , ans = 0 , currWinSum = 0 ;
        for(int c : cardPoints) totalSum += c;
        if(cardPoints.length == k) return totalSum;
        int i = 0 , j = 0;
        while(j < cardPoints.length){
            currWinSum += cardPoints[j];
            if(j - i + 1 == cardPoints.length - k){
                ans = Math.max( ans , totalSum - currWinSum);
                currWinSum -= cardPoints[i++];
            }
            j++;
        }
        return ans;
    }
}