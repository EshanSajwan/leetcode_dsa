class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi = 0;
        for(int c : candies) if(maxi < c) maxi = c;
        List<Boolean> al = new ArrayList<>();
        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] + extraCandies >= maxi) al.add(true);
            else al.add(false);
        }
        return al;
    }
}