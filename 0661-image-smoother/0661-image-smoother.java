class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length , n = img[0].length;
        int[][] smooth = new int[m][n];
        int[][] Dir = {{-1 , 0} , {-1 , +1} , {0 , +1} , {+1 , +1} ,
                        {+1 , 0} , {+1 , -1} , {0 , -1} , {-1 , -1}};
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int x = 1 , sum = img[i][j];
                for(int[] dir : Dir){
                    int newR = i + dir[0] , newC = j + dir[1];
                    if(newR < m && newR > -1 && newC < n && newC > -1 ){
                        x++;
                        sum += img[newR][newC];
                    }
                }
                smooth[i][j] = sum / x;
            }
        }
        return smooth;
    }
}