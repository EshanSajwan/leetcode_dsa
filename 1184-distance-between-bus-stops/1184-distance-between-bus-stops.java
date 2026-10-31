class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // d - s , (s - 0) - 1 then n - 1 to des
        int a = Math.min(start , destination) , b = Math.max(start , destination);
        if(a == b) return 0;
        int option1 = 0;
        for(int i = a ; i < b ; i++) option1 += distance[i];
        int option2 = 0 ;
        for(int i = 0 ; i < a ; i++) option2 += distance[i];
        for(int i = b ; i < distance.length ; i++) option2 += distance[i];
        return Math.min(option1 , option2);
    }
}