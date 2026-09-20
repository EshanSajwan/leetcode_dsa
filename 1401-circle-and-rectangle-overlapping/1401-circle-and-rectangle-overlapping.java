class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xRange = Math.min( Math.abs(xCenter - x1) , Math.abs(xCenter - x2));
        int yRange = Math.min( Math.abs(yCenter - y1) , Math.abs(yCenter - y2));
        return ( xCenter <= x2 && xCenter >= x1 && 
                  yCenter <= y2 && yCenter >= y1 ) ||
                (xRange <= radius && yCenter <= y2 && yCenter >= y1) ||
                (yRange <= radius && xCenter <= x2 && xCenter >= x1)
                // radius to each corner dist check karni padegi
                || ( Math.sqrt( (xCenter - x1 ) * (xCenter - x1) + (yCenter - y1) * (yCenter - y1)) <= radius) ||
                ( Math.sqrt( (xCenter - x2 ) * (xCenter - x2) + (yCenter - y2) * (yCenter - y2) ) <= radius) ||
                ( Math.sqrt( (xCenter - x2 ) * (xCenter - x2) + (yCenter - y1) * (yCenter - y1)) <= radius) ||
                ( Math.sqrt( (xCenter - x1 ) * (xCenter - x1) + (yCenter - y2) * (yCenter - y2) ) <= radius)                ;
    }
}