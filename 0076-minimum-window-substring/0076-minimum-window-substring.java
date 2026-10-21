class Solution {
    public String minWindow(String s, String t) {
        int tarF[] = new int[256] , sF[] = new int[256];
        for(char ch : t.toCharArray()) tarF[ch]++;
        int mini = Integer.MAX_VALUE , i = 0;
        String ans = "";
        for(int j = 0 ; j < s.length() ; j++){
            sF[s.charAt(j)]++;
            while(j - i + 1 >= t.length() && checkKar(sF , tarF)){
                if(j - i + 1 < mini){
                    mini = j - i + 1;
                    ans = s.substring(i , j + 1);
                }
                sF[s.charAt(i)]--;
                i++;
            }
        }
        return ans;
    }
    private boolean checkKar(int[] a , int[] b){
        for(int i = 0 ; i < 256 ; i++){
            if(b[i] != 0 && b[i] > a[i]) return false;
        }
        return true;
    }
}