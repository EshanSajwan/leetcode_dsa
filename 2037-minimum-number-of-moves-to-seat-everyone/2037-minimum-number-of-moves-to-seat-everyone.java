class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int opn = 0;
        for(int i = 0 ; i < seats.length ; i++)
            opn += Math.abs(seats[i] - students[i]);
        return opn;
    }
}