class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] arr = text.split(" ");
        Arrays.sort(arr ,  (a, b) -> a.length() - b.length() );
        String res = "";
        for(String s : arr) res += s + " ";
        char first = res.charAt(0);
        if(first >= 'a' && first <= 'z') first = (char)(first - 'a' + 'A');
        return first + res.substring(1 , res.length() - 1);
    }
}