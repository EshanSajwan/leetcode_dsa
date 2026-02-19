class Solution {
    class Pair{
        char alpha;
        int val;
        Pair(char x , int val){
            this.alpha = x; this.val = val;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxH = new PriorityQueue<>( (x , y) -> y.val - x.val );
        if(a != 0 ) maxH.offer(new Pair('a' , a));
        if(b != 0 ) maxH.offer(new Pair('b' , b));
        if(c != 0 ) maxH.offer(new Pair('c' , c));
        StringBuilder sb = new StringBuilder();
        while(!maxH.isEmpty()){
            Pair curr = maxH.poll();
            char currAlpha = curr.alpha; int currVal = curr.val;
            if(sb.length() == 0){
                if(currVal == 1){
                    sb.append(currAlpha);
                } else if(currVal == 2){
                    sb.append(currAlpha);  sb.append(currAlpha);
                } else{
                    sb.append(currAlpha);  sb.append(currAlpha);
                    maxH.add(new Pair(currAlpha , currVal - 2));
                }
            }
            else if(sb.length() > 0 && sb.charAt(sb.length() -1) != curr.alpha){
                if(currVal == 1){
                    sb.append(currAlpha);
                } else if(currVal == 2){
                    sb.append(currAlpha);  sb.append(currAlpha);
                } else{
                    sb.append(currAlpha);  sb.append(currAlpha);
                    maxH.add(new Pair(currAlpha , currVal - 2));
                }
            } else {
                if(maxH.isEmpty()) return penetrate(sb , currAlpha , currVal).toString();
                else{
                    Pair nextCurr = maxH.poll();
                    char nextChar = nextCurr.alpha; int nextVal = nextCurr.val;
                    if(nextVal == 1){
                    sb.append(nextChar);
                    } else if(nextVal == 2){
                        sb.append(nextChar);  sb.append(nextChar);
                    } else{
                        sb.append(nextChar);  sb.append(nextChar);
                        maxH.add(new Pair(nextChar , nextVal - 2));
                    }
                    maxH.offer(curr);
                }
            } 
        }
        return sb.toString();
    }
    private StringBuilder penetrate(StringBuilder sb , char alpha , int val){
        for(int i = 1; i < sb.length() ; i++){
            if(sb.charAt(i-1) != alpha && sb.charAt(i) != alpha) {
                if(val == 1 ) {
                    sb.insert(i , alpha);
                    return sb;
                }else if(val == 2){
                    sb.insert(i , alpha);sb.insert(i , alpha);
                    return sb;
                }else{
                    sb.insert(i , alpha);sb.insert(i , alpha);
                    val -= 2;
                }
            }

        }
        return sb;
    }
}