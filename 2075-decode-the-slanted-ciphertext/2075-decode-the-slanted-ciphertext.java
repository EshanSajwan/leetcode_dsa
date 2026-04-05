class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        char arr[][] = new char[rows][cols];
        int p = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++) arr[i][j] = encodedText.charAt(p++);
        }
        p = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < cols ; i++){
            int c = i;
            for(int r = 0 ; r < rows ; r++){
                if(c == cols) break;
                sb.append(arr[r][c++]); 
            }
        }
        while(sb.length() > 0 && sb.charAt(sb.length() -1) == ' ') sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}