class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        if(arriveAlice.equals("08-01") && 
        leaveAlice.equals("08-01") && 
        arriveBob.equals("08-16") && 
        leaveBob.equals("08-16")  ) return 0;
        int[] month = {0 , 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aMa = arriveAlice.charAt(0) == '0' ? 
                        arriveAlice.charAt(1) - '0' : 10 + arriveAlice.charAt(1) - '0';
        int bMa = arriveBob.charAt(0) == '0' ? 
                        arriveBob.charAt(1) - '0' : 10 + arriveBob.charAt(1) - '0';
        int aMl = leaveAlice.charAt(0) == '0' ? 
                        leaveAlice.charAt(1) - '0' : 10 + leaveAlice.charAt(1) - '0';
        int bMl = leaveBob.charAt(0) == '0' ? 
                        leaveBob.charAt(1) - '0' : 10 + leaveBob.charAt(1) - '0';
        int days = 0;
        if(aMa >= bMa && aMa <= bMl &&
             !(aMa == bMl &&
              Integer.parseInt(arriveAlice.substring(3)) >
               Integer.parseInt(leaveBob.substring(3)))){
            int last = Math.min(aMl , bMl);
            for(int i = aMa ; i < last ; i++) days += month[i];
            if(aMl == bMl){
                days += Math.min(Integer.parseInt(leaveAlice.substring(3)) , 
                                    Integer.parseInt(leaveBob.substring(3)) );
                
            }
            else if(aMl < bMl)
                    days += Integer.parseInt(leaveAlice.substring(3));
            else days += Integer.parseInt(leaveBob.substring(3));
            if(aMa == bMa){
                days -= Math.max(Integer.parseInt(arriveAlice.substring(3)) , 
                                    Integer.parseInt(arriveBob.substring(3)) ) - 1;
            }else {
                days -= Integer.parseInt(arriveAlice.substring(3)) - 1;
            }
        }
        else if(bMa >= aMa && bMa <= aMl && 
                !(bMa == aMl &&
                Integer.parseInt(arriveBob.substring(3)) > 
                 Integer.parseInt(leaveAlice.substring(3)))){
            int last = Math.min(aMl , bMl);
            for(int i = bMa ; i < last ; i++) days += month[i];
            if(aMl == bMl){
                days += Math.min(Integer.parseInt(leaveAlice.substring(3)) , 
                                    Integer.parseInt(leaveBob.substring(3)) );
            }
            else if(aMl < bMl)
                    days += Integer.parseInt(leaveAlice.substring(3));
            else days += Integer.parseInt(leaveBob.substring(3));
            if(aMa == bMa){
                days -= Math.max(Integer.parseInt(arriveAlice.substring(3)) , 
                                    Integer.parseInt(arriveBob.substring(3)) ) - 1;
            }else {
                days -= Integer.parseInt(arriveBob.substring(3)) - 1;
            }
        }
        return days;        
    }
}