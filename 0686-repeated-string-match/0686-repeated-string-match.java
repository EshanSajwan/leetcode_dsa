class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)) return 1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length() || sb.length() <= (a.length() + a.length()) * 2){
            sb.append(a);
            count++;
            if(sb.toString().contains(b)) return count;
        }
        return -1;
    }
}