class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer , Integer> stops = new TreeMap<>();
        for(int[] t : trips){
            stops.put( t[1] , stops.getOrDefault( t[1] , 0) + t[0]);
            stops.put( t[2] , stops.getOrDefault( t[2] , 0) - t[0]);
        }
        for(Map.Entry<Integer , Integer> e : stops.entrySet()){
            capacity -= e.getValue();
            if(capacity < 0) return false;
        }
        return true;
    }
}