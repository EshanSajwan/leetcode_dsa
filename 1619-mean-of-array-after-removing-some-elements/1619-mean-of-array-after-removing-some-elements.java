class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double res = 0;
        int k = arr.length / 20;
        for(int i = k ; i < arr.length - k ; i++) res += arr[i];
        return res / (arr.length - 2 * k);
    }
}