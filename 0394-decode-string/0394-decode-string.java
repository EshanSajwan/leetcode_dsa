class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek().charAt(0) != '['){
                    sb.insert(0 , stack.pop());
                }
                stack.pop();
                // sb.reverse();
                int num = 0 , d = 1;
                while(!stack.isEmpty() && 
                    Character.isDigit(stack.peek().charAt(0))){
                    num = (stack.pop().charAt(0) - '0') * d + num;
                    d *= 10;
                }
                String curr = sb.toString();
                for(int i = 0 ; i < num - 1 ; i++) sb.append(curr);
                stack.push(sb.toString());
            }
            else stack.push("" + ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0 , stack.pop());
        return sb.toString();
    }
}