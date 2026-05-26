class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> freq = new HashMap<>();
        for(int i : arr) freq.put(i , freq.getOrDefault(i , 0) + 1);
        int[] occurance = new int[1001];
        for(int i : freq.values()){
            if(occurance[i] == 1) return false;
            occurance[i] = 1;
        }
        return true;
    }
}