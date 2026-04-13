class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // if(bits.length == 1 ||
        //     (
        //         bits.length == 2 && bits[0] != 1
        //     ) ||
        //     (
        //         bits.length == 3 && bits[bits.length - 3] == 1
        //     ) ||
        //     (
        //         bits.length == 3 && bits[bits.length - 2] == 0
        //     )
        // )  return true;
        int temp = 0;
        for(int i : bits){
            if(temp == 0 && i == 0 ) continue;
            else if(temp > 9){
                temp = i;
            } else {
                temp = ( temp * 10 ) + i;
            }
        }
        return temp == 0;
    }
}