class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) freq[c - 'A']++;
         //[ id , count , prev]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> {
            if(a[1] == b[1]){
                return Integer.compare(a[2] , b[2]);
            }
            return Integer.compare(b[1] , a[1]);
        } );
        for(int i = 0 ; i < 26 ; i++) {
            if(freq[i] > 0) pq.offer( new int[]{i , freq[i] , -1});
        }
        Stack<int[]> stack = new Stack<>();
        int timer = 0;
        while( !pq.isEmpty() ){
            boolean isDone = false;
            while( !pq.isEmpty() ){
                int[] curr = pq.poll();
                if( curr[2] == -1 || timer - curr[2] > n){
                    if(curr[1] > 1) pq.offer( new int[]{curr[0] , curr[1] - 1 , timer});
                    timer++;
                    isDone = true;
                    break;
                }
                else stack.push(curr);
            }
            if(isDone)
            while(!stack.isEmpty()) pq.offer( stack.pop() );
            else
            {
                int min = Integer.MAX_VALUE;
                while(!stack.isEmpty()) {
                    min = Math.min( min , stack.peek()[2]);
                    pq.offer( stack.pop() );
                }
                timer = min + n + 1;
            }
        }
        return timer;
    }
}