class Solution {
    public String sortSentence(String s) {
        String[] sentence = s.split(" ");
        String[] arr = new String[sentence.length];
        for(String word : sentence){
            int index = -1 , x = -1;
            if(word.length() > 3 && Character.isDigit(word.charAt(word.length() - 3)))
                {
                    index = Integer.parseInt(word.substring(word.length() - 3)) - 1;
                    x = word.length() - 3;
                }
            else if(word.length() > 2 && Character.isDigit(word.charAt(word.length() - 2)))
                {
                    index = Integer.parseInt(word.substring(word.length() - 2)) - 1;
                    x = word.length() - 2;
                }
            else {
                index = word.charAt(word.length() - 1) - '0' - 1;
                // index = Integer.parseInt(word.substring(s.length() - 1)) - 1;
                x = word.length() - 1;
            }
            arr[index] = word.substring(0 , x); 
        }
        StringBuilder sb = new StringBuilder();
        for(String ssss : arr) sb.append(ssss).append(" ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}