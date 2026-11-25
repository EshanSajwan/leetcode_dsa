class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0 , maxi = 0;
        for(int i : gain){
            alt += i;
            maxi = Math.max(maxi , alt);
        }
        return maxi;
    }
}