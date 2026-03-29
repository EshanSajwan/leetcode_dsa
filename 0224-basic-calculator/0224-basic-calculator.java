class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < sb.length() ; i++) if(sb.charAt(i) == ' ') sb.deleteCharAt(i--);
        s = sb.toString();
        Stack<String> stack = new Stack<>();
        char op = '+';
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '+') op = '+';
            else if(ch == '-') {
                op = '-';
                if(s.charAt(i + 1) == '(') stack.push("-");
            }
            else if(ch == '(') {
                stack.push("(");
                op = '+';
            }
            else if(ch == ')'){
                int value = 0;
                while(true){
                    String curr = stack.pop();
                    if(curr.equals("(")){
                        if(!stack.isEmpty() && !stack.peek().equals("-")){
                            if(value < 0) stack.push("-" + String.valueOf(Math.abs(value)) );
                            else stack.push( "+" + String.valueOf(value) );
                        }
                        else if(stack.isEmpty()){
                            if(value < 0) stack.push("" + String.valueOf(value) );
                            else stack.push( "+" + String.valueOf(value) );
                        }
                        else {
                            stack.pop();
                            if(value < 0) stack.push("+" + String.valueOf(Math.abs(value)) );
                            else stack.push( "-" + String.valueOf(value) );
                        }
                        
                        break;
                    }
                    int currValue = 0;
                    if(curr.charAt(0) == '+') currValue = Integer.parseInt(curr.substring(1));
                    else currValue = -(Integer.parseInt(curr.substring(1)));
                    value += currValue;
                }
            }
            else{
                int j = i + 1;
                while(j < n && Character.isDigit(s.charAt(j))) j++;
                if(op == '+') stack.push("+" + s.substring(i , j));
                else stack.push("-" + s.substring(i , j));
                i = j-1;
            }
        }

        long value = 0;
        while(!stack.isEmpty()){
            String curr = stack.pop();

            long currValue = 0;
            if(curr.charAt(0) == '+') currValue = Long.parseLong(curr.substring(1));
            else currValue = -(Long.parseLong(curr.substring(1)));
            value += currValue;
        }
        return (int)value;
    }
}