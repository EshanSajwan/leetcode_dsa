class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        boolean[] exc = new boolean[instructions.length];
        int i = 0 ; long score = 0;
        while( i < instructions.length && i > -1){
            if(exc[i]) break;
            exc[i] = true;
            if(instructions[i].charAt(0) == 'a'){
                score += values[i];
                i++;
            }
            else   i += values[i];
        }
        return score;
    }
}