class Solution {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        int last = -1;
        for(String num : arr){
            if(Character.isDigit(num.charAt(0))){
                int newNum = Integer.parseInt(num);
                if(newNum <= last) return false;
                else last = newNum;
            }
        }
        return true;
    }
}