class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i = 0 , j = arr.length - 1 , n = arr.length;
        while(i + 1 < n && arr[i] < arr[i + 1]) i++;
        if(i == 0) return false;
        while(j - 1 > -1 && arr[j] < arr[j - 1]) j--;
        if(j == n - 1) return false;
        return i == j;
    }
}