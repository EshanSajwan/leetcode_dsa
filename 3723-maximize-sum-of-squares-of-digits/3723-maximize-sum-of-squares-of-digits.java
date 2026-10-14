class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";
        String x = "";
        int nines = sum / 9;
        x += "9".repeat(nines);
        num -= nines;
        if(num > 0) x += String.valueOf(sum - nines * 9);
        num--;
        if(num > 0) x += "0".repeat(num);
        return x;
    }
}