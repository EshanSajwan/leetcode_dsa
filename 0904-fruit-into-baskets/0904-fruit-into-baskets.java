class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1) return 1;
        int i = 0 , j = 1 , t1 = fruits[0] , t2 = -1 , t1Lx = 0 , t2Lx = -1 , ans = 0;
        while(j < fruits.length){
            if(t2 == -1 && fruits[j] != t1) t2 = fruits[j];
            while(fruits[j] != t1 && fruits[j] != t2){
                if(fruits[i] == t1 && t1Lx == i) t1 = fruits[j];
                else if(fruits[i] == t2 && t2Lx == i) t2 = fruits[j];
                i++;
            }
            if(fruits[j] == t1) t1Lx = j;
            else t2Lx = j;
            ans = Math.max(ans , j++ - i + 1);
        }
        return ans;
    }
}