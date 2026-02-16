class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int u = 0 , d = matrix.length -1,  l = 0 , r = matrix[0].length-1;
        while(l <= r && u <= d){
            for(int j = l ; j <= r ;j++) list.add(matrix[u][j]);
            u++;
            for(int i = u ; i <= d ;i++) list.add(matrix[i][r]);
            r--;
            if(d >= u){
                for(int j = r ; j >= l ; j--) list.add(matrix[d][j]);
                d--;
            }
            if(l <= r){
                for(int i = d ; i >= u ; i--) list.add(matrix[i][l]);
                l++;
            }
        }
        return list;
    }
}