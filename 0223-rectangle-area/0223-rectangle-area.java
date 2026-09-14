class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aAr = Math.abs(ax1 - ax2) * Math.abs( ay1 - ay2 ) ,
            bAr = Math.abs(bx1 - bx2) * Math.abs( by1 - by2 ) ;
        int common = 0;
        if(ax1 < bx2 && bx1 < ax2 && ay1 < by2 && by1 < ay2){
            // overlapping toh hai
            // kya inside hai?
            // if((ay1 <= by1 && ay2 >= by2) || (by1 <= ay1 && by2 >= ay2)){
            //     if(ay1 <= by1 && ay2 >= by2){
            //         common = bAr;
            //     }
            //     else common = aAr;
            // }
            // else{
            //     int x1 = 0 , x2 = 0 , y1 = 0 , y2 = 0;
            //     // right me kon hai
            //     if(ax2 > bx2){
            //         x1 = ax1;
            //         x2 = bx2;
            //     }else{
            //         x1 = bx1;
            //         x2 = ax2;
            //     }
            //     // upar kon hai
            //     if(ay2 > by2){
            //         y1 = ay1;
            //         y2 = by2;
            //     }else{
            //         y1 = by1;
            //         y2 = ay2;
            //     }
            //     common = Math.abs(x1- x2) * Math.abs(y1 - y2);
            // }

            // x x vale middle ke dono nikal or y y ka bhi 
            int x1 = 0 , x2 = 0 , y1 = 0 , y2 = 0;
            int[] xs = {ax1 , ax2 , bx1 , bx2};
            Arrays.sort(xs);
            if(xs[0] == xs[1]){
                x1 = xs[1];
                x2 = xs[2];
            }
            else if(xs[2] == xs[3]){
                x1 = xs[1];
                x2 = xs[2];
            }
            else{
                x1 = xs[1];
                x2 = xs[2];
            }
            int[] ys = {ay1 , ay2 , by1 , by2};
            Arrays.sort(ys);
            if(ys[0] == ys[1]){
                y1 = ys[1];
                y2 = ys[2];
            }
            else if(ys[2] == ys[3]){
                y1 = ys[1];
                y2 = ys[2];
            }
            else{
                y1 = ys[1];
                y2 = ys[2];
            }
            common = Math.abs(x1 - x2) * Math.abs(y1 - y2);
        }
        return aAr + bAr - common;
    }
}