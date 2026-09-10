class Solution {
    public double average(int[] salary) {
        int max = salary[0] , min = salary[0];
        double sum = 0;
        for(int i = 0 ; i < salary.length ; i++){
            sum += salary[i];
            max = Math.max( max , salary[i] );
            min = Math.min( min , salary[i] );
        }
        
        // for(int i : salary){
        //     if(i == max || i == min) continue;
        //     sum += i;
        // }
        return (sum - max - min) / (salary.length - 2);
    }
}