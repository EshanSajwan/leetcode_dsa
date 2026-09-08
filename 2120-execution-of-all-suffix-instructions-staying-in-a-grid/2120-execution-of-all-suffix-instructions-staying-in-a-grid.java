class Solution {
    int n , sR , sC;
    String s;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        this.n = n;
        sR = startPos[0];
        sC = startPos[1];
        this.s = s;
        int[] answer = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            answer[i] = rec(i , sR , sC );
        }
        return answer;
    }
    private int rec( int index  , int i , int j){
        if(i == -1 || i == n || j == -1 || j == n) return -1;
        if(index == s.length()) return 0;
        if(s.charAt(index) == 'R')
        return 1 + rec( index + 1 , i , j + 1);
        if(s.charAt(index) == 'D')
        return 1 + rec( index + 1 , i + 1 , j);
        if(s.charAt(index) == 'L')
        return 1 + rec( index + 1 , i , j - 1);
        // else 'U'
        return 1 + rec( index + 1 , i - 1 , j);
    }
}