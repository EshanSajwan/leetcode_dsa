class Solution {
    public String capitalizeTitle(String title) {
        String[] tit = title.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < tit.length ; i++){
            StringBuilder sb =  new StringBuilder(tit[i]);
            if(sb.length() < 3){
                for(int idx = 0 ; idx < sb.length() ; idx++){
                    sb.setCharAt(idx , Character.toLowerCase(sb.charAt(idx)));
                }
            }else {
                sb.setCharAt(0 , Character.toUpperCase(sb.charAt(0)));
                for(int idx = 1 ; idx < sb.length() ; idx++){
                    sb.setCharAt(idx , Character.toLowerCase(sb.charAt(idx)));
                }
            }
            ans.append(sb);
            if(i < tit.length -1) ans.append(" ");
        }
        return ans.toString();
    }
}