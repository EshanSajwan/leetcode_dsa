class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ins = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt( i );
            if(ch == '(') stack.push(ch);
            else{
                if(stack.isEmpty()){
                    if(i + 1 == s.length() || s.charAt(i + 1) == '('){
                        ins += 2;
                    }
                    else{
                        ins++;
                        i++;
                    }
                }
                else{
                    if(i + 1 == s.length() || s.charAt(i + 1) == '('){
                        ins++;
                    }
                    else{
                        i++;
                    }
                    stack.pop();
                }
            }
        }
        return ins + 2 * stack.size();
    }
}