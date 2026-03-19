class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        boolean flag = false;
        for(int i = 0 ; i < expression.length() ; i++){

            if(!Character.isDigit(expression.charAt(i))){

                flag = true;
                List<Integer> left = diffWaysToCompute(expression.substring(0 , i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // result.add(calc(left.get(0) , right.get(0) , expression.charAt(i)));

                for(int j : left){
                    for(int k : right){
                        result.add(calc( j , k , expression.charAt(i)));
                    }
                }
            }
        }
        if(!flag) result.add(Integer.parseInt(expression));
        return result;
    }
    private int calc(int a , int b , char op){
        switch(op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default :
                return 9;
        }
    }
}