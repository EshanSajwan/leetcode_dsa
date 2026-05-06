class Solution {
    public int dayOfYear(String date) {
        String year = date.substring(0 , 4);
        int yr = Integer.parseInt(year);
        boolean leapYear = (yr % 400 == 0) || ((yr % 4 == 0) && (yr % 100 != 0));
        String month = date.substring(5 , 7);
        int mm = Integer.parseInt(month);
        int day = 0;
        for(int i = 1 ; i < mm ; i++){
            if(leapYear && i == 2) day += 29;
            else {
                switch(i){
                    case 1,3,5,7,8,10,12 -> day += 31;
                    case 2 ->               day += 28;
                    case 4,6,9,11 ->        day += 30;
                }
            }
        }
        String currDate = date.substring(8);
        int dd = Integer.parseInt(currDate);
        return day + dd;
    }
}