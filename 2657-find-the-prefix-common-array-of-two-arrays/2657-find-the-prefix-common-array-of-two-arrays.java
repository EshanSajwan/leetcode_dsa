class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] a = new int[51];
        int[] b = new int[51];
        int[] c = new int[A.length];
        for(int i = 0 ; i < A.length ; i++){
            int ans = 0;
            if(i > 0) ans = c[i-1];
            if(A[i] == B[i]) ans++;
            else{
                if(b[A[i]] == 1) ans++;
                a[A[i]] = 1;
                if(a[B[i]] == 1) ans++;
                b[B[i]] = 1;
            }
            c[i] = ans;
        }
        return c;
    }
}