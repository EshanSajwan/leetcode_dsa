class Solution {
    public String mostCommonWord(String p, String[] banned) {
        String sp = "!?',;.";
        Set<String> ban = new HashSet<>();
        for(String s : banned) ban.add(s);
        int maxi = 0;
        Map<String , Integer> map = new HashMap<>();
        int i = 0 ; int j = i + 1;
        while(i < p.length()){
            while(j < p.length() && Character.isLetter(p.charAt(j))) j++;
            String valid = p.substring(i , j);
            valid = valid.toLowerCase();
            if(!ban.contains(valid)) {map.put(valid , map.getOrDefault(valid , 0 ) + 1);
            maxi = Math.max(map.get(valid) , maxi);}
            i = j;
            j++;
            while(i < p.length() && !Character.isLetter(p.charAt(i))){
                i++;
                j++;
            }
        }
        for(String s : map.keySet()) if(map.get(s) == maxi) return s;
        return "unreachable";
    }
}