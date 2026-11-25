class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids){
            if(ast > 0) stack.push(ast);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && 
                    stack.peek() < -1 * ast) stack.pop();
                if(stack.isEmpty()) stack.push(ast); 
                else if(stack.peek() < 0) stack.push(ast);
                else if(stack.peek() == -1 * ast) stack.pop();
            }
        }
        int arr[] = new int[stack.size()];
        for(int i = arr.length - 1 ; i > -1 ; i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}