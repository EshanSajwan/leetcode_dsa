class Solution {
    public boolean canPlaceFlowers(int[] fb, int n) {
        if(fb.length == 1){
            if(n == 1 && fb[0] == 1) return false;
            return true;
        }
        for(int i = 0 ; i < fb.length - 1 ; i++){
            if(fb[i] == 1 && fb[i + 1] == 1) return false;
        }
        if(fb[0] == 0 && fb[1] == 0 && n > 0) {
            n--;
            fb[0] = 1;
        }
        if(fb[fb.length - 1] == 0 && fb[fb.length - 2] == 0 && n > 0) {
            n--;
            fb[fb.length - 1] = 1;
        }
        for(int i = 1 ; i < fb.length - 1 && n > 0 ; i++){
            if(fb[i] == 0 && fb[i - 1] == 0 && fb[i + 1] == 0){
                n--;
                fb[i] = 1;
            }
        }
        return n == 0;
        
    }
}