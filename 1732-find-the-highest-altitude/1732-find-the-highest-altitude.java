class Solution {
    public int largestAltitude(int[] gain) {
        int currAlt = 0 , highest = 0;
        for(int i : gain){
            currAlt += i;
            if(currAlt > highest) highest = currAlt;
        }
        return highest;
    }
}