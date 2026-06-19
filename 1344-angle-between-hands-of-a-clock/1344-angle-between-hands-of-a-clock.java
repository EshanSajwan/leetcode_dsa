class Solution {
    public double angleClock(int hour, int minutes) {
        double hh , mh;
        hh = (double)hour * 30 + (double)minutes / 2;
        mh = (double)minutes * 6;
        return Math.min(
            Math.max(hh , mh) - Math.min(hh , mh) , 360 - (Math.max(hh , mh) - Math.min(hh , mh))
        );
    }
}