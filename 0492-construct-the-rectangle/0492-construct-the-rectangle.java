class Solution {
    public int[] constructRectangle(int area) {
        int l = 0 ; int w = 10000000;
        int num = (int)Math.floor(Math.sqrt(area));
        while(num > 0){
            if(area % num == 0){
                int side = area / num;
                l = Math.max(side , num);
                w = Math.min(side , num);
                break;
            }
            num--;
        }
        if(num == 0){
             l = area;
              w = 1;
        }
        return new int[]{l , w};
    }
}