class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length , n = grid[0].length;
        int top = 0 , bottom = m-1 , left = 0 , right = n-1;
        int topX = 0 , bottomX = m-1 , leftX = 0 , rightX = n-1;
        int[][] mat = new int[m][n];
        while( top <= bottom && left <= right){
            List<Integer> al = new ArrayList<>();
            for(int i = top ; i <= bottom ; i++) al.add(grid[i][left]);
            left++;
            for(int i = left ; i <= right ; i++) al.add(grid[bottom][i]);
            bottom--;
            if(left <= right) for(int i = bottom ; i >= top ; i--) al.add(grid[i][right]);
            right--;
            if(top <= bottom) for(int i = right ; i >= left ; i--) al.add(grid[top][i]);
            top++;

            int size = al.size() ;
            int kk = k;
            kk %= size;
            int index = size - kk;
            index %= size;
            for(int i = topX ; i <= bottomX ; i++) {
                mat[i][leftX] = al.get(index);
                index++; index %= size;
            }
            leftX++; 
            for(int i = leftX ; i <= rightX ; i++) {
                mat[bottomX][i] = al.get(index);
                index++; index %= size;
            }
            bottomX--; 
            if(leftX <= rightX) for(int i = bottomX ; i >= topX ; i--) {
                mat[i][rightX] = al.get(index);
                index++; index %= size;
            }
            rightX--;
            if(topX <= bottomX) for(int i = rightX ; i >= leftX ; i--) {
                mat[topX][i] = al.get(index);
                index++; index %= size;
            }
            topX++; 
        }
        return mat;
    }
}