class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] nextDay = new int[cells.length];
        for(int i = 0 ; i < cells.length ; i++){
            if(i != 0 && i != cells.length - 1) {
                if(cells[i-1] == cells[i + 1]) nextDay[i] = 1;
                else nextDay[i] = 0;
            }
        }
        cells = nextDay.clone();
        n = (n - 1) % 14 + 1;
        for(int day = 2 ; day <= n ; day++){
            for(int i = 1 ; i < cells.length - 1 ; i++){
                if(i != 0 && i != cells.length - 1) {
                    if(cells[i-1] == cells[i + 1]) nextDay[i] = 1;
                    else nextDay[i] = 0;
                }
            }
            cells = nextDay.clone();
        }
        return cells;
    }
}