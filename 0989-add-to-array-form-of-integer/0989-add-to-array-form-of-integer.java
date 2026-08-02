class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        for(int i = num.length - 1 ; i > -1 ; i--){
            int k_ka = k % 10;
            k /= 10;
            int sum = carry + num[i] + k_ka;
            if(sum > 9){
                carry = 1;
                ans.add( sum % 10);
            }
            else {
                carry = 0;
                ans.add(sum);
            }
        }
        if(carry == 1) k++;
        while(k != 0) {
            ans.add(k % 10);
            k /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}