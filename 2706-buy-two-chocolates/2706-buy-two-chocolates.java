class Solution {
    public int buyChoco(int[] prices, int money) {
        int mini = 101 , secMini = 101;
        for(int i : prices){
            if(i < mini) {
                secMini = mini;
                mini = i;
            }
            else if(i < secMini) secMini = i;
        }
        if(secMini + mini > money) return money;
        return money - secMini - mini;
    }
}