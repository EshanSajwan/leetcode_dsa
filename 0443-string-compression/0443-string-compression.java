class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < chars.length ; ){
            char curr = chars[i];
            int j = i + 1 , count = 1;
            while(j < chars.length && chars[j] == curr){
                count++;
                j++;
            }
            sb.append(curr);
            if(count > 1) sb.append(count);
            i = j;
        }
        for(int i = 0 ; i < sb.length() ; i++) chars[i] = sb.charAt(i);
        return sb.length();
    }
}