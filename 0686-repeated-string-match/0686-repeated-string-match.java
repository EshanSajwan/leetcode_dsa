class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)) return 1;
        StringBuilder sb = new StringBuilder();
        sb.append(a.repeat((b.length() + a.length() - 1) / a.length()));
        if(sb.toString().contains(b)) 
        return (a.length() + b.length() - 1) / a.length();
        sb.append(a);
        if(sb.toString().contains(b)) 
        return (a.length() + b.length() - 1) / a.length() + 1;
        return -1;
    }
}