class Solution {
    class army {
        int row;
        int soldiers; 
        army(int r , int s){
            this.row = r;
            this.soldiers = s;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<army> pq = new PriorityQueue<>((a, b) -> {
                                                                if(a.soldiers == b.soldiers) return a.row - b.row;
                                                                return a.soldiers - b.soldiers;
                                                              });
        for(int i = 0 ; i < mat.length ; i++){
            int c =0;
            for(int j : mat[i]) if(j == 1) c++;
            pq.offer(new army(i , c));
        }
        int[] result = new int[k];
        for(int i = 0 ; i < k ;i++) result[i] = pq.poll().row;
        return result;
    }
}