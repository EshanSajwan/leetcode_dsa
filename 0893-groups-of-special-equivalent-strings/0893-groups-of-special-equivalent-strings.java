class Solution {
    class Arr{
        int[] arr , freq;
        Arr(int[] arr , int[] freq){
            this.freq = freq;
            this.arr = arr;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(this == null || this.getClass() != o.getClass()) return false;
            Arr curr = (Arr)o;
            return Arrays.equals(this.arr , curr.arr) && 
                    Arrays.equals(this.freq , curr.freq);
        }

        @Override
        public int hashCode(){
            return Arrays.hashCode(arr) + Arrays.hashCode(freq);
        }
    }
    public int numSpecialEquivGroups(String[] words) {
        Set<Arr> set = new HashSet<>();
        for(String s : words){
            int[] alpha = new int[26] , freq = new int[26];
            Arr newArr = new Arr(alpha , freq);
            for(int i = 0 ; i < s.length() ; i++){
                char ch = s.charAt(i);
                freq[ch - 'a']++;
                if((i & 1) == 1) alpha[ch -'a']--;
                else alpha[ch - 'a']++;
            }
            if(!set.contains(newArr)) set.add(newArr);
        }
        return set.size();
    }
}