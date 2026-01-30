class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        Stack<Integer> stack = new Stack<>();
        int i = 0 , n = num.length();
        for(i = 0 ; i < n ; i++){
               
            while(!(stack.isEmpty() || stack.peek() <= (num.charAt(i) - '0')) && k != 0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i) - '0');
            
        }
        // i--;
        // while(i < num.length()) stack.push(num.charAt(i++) - '0');
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //Remove Leading 0s
        i = sb.length() -1;
        while(i > 0 && sb.charAt(i) == '0') sb.deleteCharAt(i--);
        String ans = sb.reverse().toString();
        if(ans.equals(num)) return num.substring(0 , n - k);
        if(k > 0) return removeKdigits( ans , k );
        return ans;
    }
}