class Solution {
    public String resultingString(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()) stack.push( ch - 'a' );
            else {
                int top = stack.peek();
                int x = Math.max( top , ch -'a') - Math.min(top , ch - 'a');
                if(x == 1 || x == 25){
                    stack.pop();
                }
                else stack.push(ch -'a');
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append((char)(stack.pop() + 'a'));
        return sb.reverse().toString();
    }
}