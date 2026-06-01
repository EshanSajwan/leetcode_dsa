class Solution {
    record alphaF(char c , int f){};
    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) arr[ch - 'a']++;
        PriorityQueue<alphaF> pq = new PriorityQueue<>((a, b) -> b.f - a.f);
        for(int i = 0 ; i < 26 ; i++) if(arr[i] > 0) pq.offer(new alphaF((char)(i + 'a') , arr[i]));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() ){
            //if(sb.length() > 0 && sb.charAt(sb.length() - 1) == pq.peek().c) break;
            alphaF curr =  pq.poll();
            boolean flag = false;
            if( sb.length() == 0 || (sb.charAt(sb.length() - 1) != curr.c)){
                sb.append(curr.c);
                flag = true;
            }
            if(curr.f == 1 && flag) continue;
            if(!flag && pq.size() == 0) return "";
            if(!pq.isEmpty()){
                alphaF sec = pq.poll();
                sb.append(sec.c);
                if(sec.f > 1) pq.offer(new alphaF(sec.c , sec.f - 1));
            }
            if(flag) pq.offer(new alphaF(curr.c , curr.f - 1));
            else pq.offer(curr);
        }
        if( pq.size() == 0) return sb.toString();
        return "";
    }
}