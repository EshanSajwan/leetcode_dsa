class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 1 , i3 = 1 , i5 = 1;
        int[] arr = new int[n +1];
        arr[1] = 1;
        for(int i = 2; i <= n ; i++){
            int ugly1 = arr[i2] * 2;
            int ugly2 = arr[i3] * 3;
            int ugly3 = arr[i5] * 5;
            int currUgly = Math.min( ugly1 , Math.min( ugly2 , ugly3));
            arr[i] = currUgly;
            if(currUgly == ugly1) i2++;
            if(currUgly == ugly2) i3++;
            if(currUgly == ugly3) i5++;
        }
        return arr[n];
    }
}