class Solution {
    public String generateTheString(int n) {
        char[] arr = new char[n];
        if(n % 2 == 0){
            arr[0] = 'a';
            for(int i = 1 ; i < n ; i++) arr[i] = 'b';
        }
        else{
            for(int i = 0 ; i < n ; i++) arr[i] = 'a';
        }
        return new String(arr);
    }
}