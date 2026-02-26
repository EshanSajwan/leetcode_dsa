class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String ss : arr){
            sb.append(new StringBuilder(ss).reverse()).append(" ");
        }
        return sb.toString().trim();
    }
}