class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ins = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt( i );
            if(ch == '(') stack.push(ch);
            else{
                    if(i + 1 == s.length() || s.charAt(i + 1) == '('){
                        if(stack.isEmpty()) ins += 2;
                        else ins++;
                    }
                    else{
                        if(stack.isEmpty()) ins++;
                        i++;
                    }
                if(!stack.isEmpty()) stack.pop();
                }
            }
        return ins + 2 * stack.size();
    }
}