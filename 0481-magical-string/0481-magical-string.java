class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int pos = 2;
        char num = '1';
        while(sb.length() < n){
            int k = sb.charAt(pos++) - '0';
            for(int i = 0 ; i < k ; i++ ) sb.append(num);
            if(num == '1') num = '2';
            else num = '1';
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++) if(sb.charAt(i) == '1') count++;
        return count;
    }
}