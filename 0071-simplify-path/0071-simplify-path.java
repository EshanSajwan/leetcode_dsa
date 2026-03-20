class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        for(int i = 1 ; i < path.length() ; i++){
            if(path.charAt(i) == '/' || i == path.length() -1){

                if(!stack.isEmpty() && stack.peek().equals("/")) stack.pop();
                
                if(path.charAt(i) == '/'){
                    String curr = path.substring(start , i);
                    if(curr.equals("/.")){
                        start = i;
                    } else if(curr.equals("/..")){
                        if(!stack.isEmpty()) stack.pop();
                        start = i;
                    } else {
                        stack.push(curr);
                        start = i;
                    }
                    
                }
                else{
                    String curr = path.substring(start , i + 1);
                    
                    if(curr.equals("/.")){
                        continue;
                    } else if(curr.equals("/..")){
                        if(!stack.isEmpty()) stack.pop();
                    } else {
                        stack.push(curr);
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            String curr = stack.pop();
            if(curr.equals("/.")) continue;
            else if(curr.equals("/..")){
                if(!stack.isEmpty()) stack.pop();
                continue;
            }
            else{
                ans.insert(0 , curr);
            }
        }
        if(ans.length() == 0) return "/";
        if(ans.charAt(ans.length() -1) == '/') ans.deleteCharAt(ans.length() -1);
        if(ans.length() == 0) return "/";
        return ans.toString();
    }
}