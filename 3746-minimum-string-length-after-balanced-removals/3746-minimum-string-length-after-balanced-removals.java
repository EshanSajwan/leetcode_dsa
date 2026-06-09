class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()) stack.push(ch);
            else if(ch == 'a' && stack.peek() == 'b') stack.pop();
            else if(ch == 'b' && stack.peek() == 'a') stack.pop();
            else stack.push(ch);
        }
        return stack.size();
    }
}