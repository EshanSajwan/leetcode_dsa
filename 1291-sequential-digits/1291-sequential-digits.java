class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int l_len = findLen(low) , h_len = findLen(high);
        List<Integer> starter = new ArrayList<>();
        List<Integer> adder = new ArrayList<>();
        int xxx = 0 , st = 0 , ad = 0;
        for(int i = 1 ; i <= l_len ; i++){
            st = st * 10 + i;
            ad = ad * 10 + 1;
        }
        int k = l_len + 1;
        for(int i = l_len ; i <= h_len ; i++){
            starter.add(st);
            adder.add(ad);
            st = st * 10 + k++;
            ad = ad * 10 + 1;
        }
        int n = starter.size();
        List<Integer> al =new ArrayList<>();
        while(xxx < n){
            int num = starter.get(xxx) , sum = adder.get(xxx);
            while(num % 10 != 0 && num <= high){
                if(num >= low && num <= high ) al.add( num );
                num += sum;
            }
            xxx++;
        }
        return al;
    }
    private int findLen( int num ){
        int len = 0;
        while(num != 0){
            num /= 10;
            len++;
        }
        return len;
    }
}