class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ']'){
                stack.push(s.substring(i , i+1));
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")) sb.insert(0 , stack.pop());
                stack.pop();
                StringBuilder numS = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) numS.insert(0 , stack.pop());
                int num = Integer.parseInt(numS.toString());
                StringBuilder newS = new StringBuilder();
                for(int j = 0 ; j < num ; j++) newS.append(sb);
                stack.push(newS.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) ans.insert(0 , stack.pop());
        return ans.toString();
    }
}