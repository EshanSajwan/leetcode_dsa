class Solution {
    class StrList{
        String node;
        List<StrList> comp;
        StrList(String s){
            this.node = s;
            this.comp = new ArrayList<>();
        }
    }
    int i ;
    StrList root;
    String input;
    public int lengthLongestPath(String input) {
        this.input = input;
        i = 0;
        // while(i < input.length() && 
        // input.charAt(i) != '\t' && input.charAt(i) != '\n') i++;
        root = new StrList("");
        build(root , 0);
        int len = findMaxLenPath(root);
        return len > 0 ? len - 1 : 0;
    }
    private int findMaxLenPath(StrList root){
        if(root.comp.isEmpty()){
            String curr = root.node;
            int n = curr.length();
            if(curr.contains(".")) return curr.length();
            return (int)-1e9;
        }
        int maxi = (int)-1e9;
        String curr = root.node;
        for(StrList vx : root.comp){
            maxi = Math.max( maxi , curr.length() + 1 + findMaxLenPath(vx));
        }
        return maxi;
    }
    private boolean build(StrList root , int lvl){
        if(i == input.length()) return true;
        int pos = i , x = 0;
        if(input.charAt(pos) == '\n') pos++;
        while(pos < input.length() && input.charAt(pos) == '\t'){
            pos++;
            x++;
        }
        if(x < lvl) return false;
        int start = pos;
        while(pos < input.length() &&
         input.charAt(pos) != '\t' && input.charAt(pos) != '\n' ) pos++;
        StrList newNode = new StrList(input.substring(start , pos));
        root.comp.add(newNode);
        i = pos;
        if(build(newNode , lvl + 1)) return true;
        if(build(root , lvl)) return true;
        return false;
    }
}