class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0 , d = 0 , l = 0 , r = 0;
        for(char ch : moves.toCharArray()){
            switch(ch) {
                case 'U' -> u++;
                case 'D' -> d++;
                case 'L' -> l++;
                default -> r++;
            }    
        }
        return u == d && l == r;
    }
}