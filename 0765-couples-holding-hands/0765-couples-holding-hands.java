class Solution {
    public int minSwapsCouples(int[] row) {
        int[] position = new int[row.length];
        for(int i = 0 ; i < row.length ; i++) position[row[i]] = i;
        int swaps = 0;
        for(int i = 0 ; i < row.length ; i+=2){
            int person = row[i];
            if(person % 2 == 0 ){
                int lover = person + 1;
                if(row[i + 1] != lover){
                    int x = row[i + 1] ;
                    swap(row , i + 1 , position[lover]);
                    position[x] = position[lover];
                    position[lover] = i + 1;
                    swaps++;
                }
            }
            else{
                int lover = row[i] - 1;
                if(row[i + 1] != lover){
                    int x = row[i + 1];
                    swap(row , i + 1, position[lover] );
                    position[x] = position[lover];
                    position[lover] = i + 1;
                    swaps++;
                }
            }
        }
        return swaps;
    }
    private void swap(int[] nums , int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}