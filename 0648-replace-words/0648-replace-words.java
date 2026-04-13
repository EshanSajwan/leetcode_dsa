class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        Collections.sort(dictionary);
        int[] isIn = new int[26];
        int x = 0 , maxi = 0;
        while(x < dictionary.size()){
            while(x  < dictionary.size() - 1 && 
                dictionary.get(x + 1).startsWith(dictionary.get( x ))) dictionary.remove(x + 1);
            set.add(dictionary.get(x));
            maxi = Math.max(maxi , dictionary.get(x).length());
            isIn[dictionary.get(x).charAt(0) - 'a'] = 1;
            x++;
        }
        String[] arr = sentence.split(" ");
        for(int i = 0 ; i < arr.length ; i++){
            if(isIn[arr[i].charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0 ; j < arr[i].length() ; j++){
                sb.append(arr[i].charAt(j));
                if(set.contains(sb.toString())){
                    arr[i] = sb.toString();
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(String str : arr) ans.append(str).append(" ");
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}