class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0 , words = 0;
        for(int i = 0 ; i < text.length() ; i++){
            if(text.charAt(i) == ' ') spaces++;
            else{
                while(i < text.length() && text.charAt(i) != ' ') i++;
                i--;
                words++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(words == 1) {
            for(char c : text.toCharArray()){
                if(c != ' ') sb.append(c);
            }
            while(spaces-- > 0){
                sb.append(' ');
            }
            return sb.toString();
        }
        int sp = spaces / (words - 1);
        boolean start = false;
        
        for(int i = 0 ; i < text.length() ; i++){
            if(text.charAt(i) == ' ') {
                if(!start) continue;
                else{
                    if(spaces == 0) continue;
                    for(int j = 0 ; j < sp ; j++){
                        sb.append(' ');
                    }
                    spaces -= sp;
                    while(i < text.length() && text.charAt(i) == ' ') i++;
                    i--;
                }
            }
            else{
                start = true;
                while(i < text.length() && text.charAt(i) != ' ') 
                    sb.append(text.charAt(i++));
                i--;
                words--;
            }
            if(words == 0) break;
        }
        while(spaces-- > 0){
            sb.append(' ');
        }
        return sb.toString();
    }
}