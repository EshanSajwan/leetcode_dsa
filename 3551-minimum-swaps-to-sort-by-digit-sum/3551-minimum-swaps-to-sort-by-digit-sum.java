class Solution {
    public int minSwaps(int[] nums) {
        int[][] arr = new int[nums.length][3];
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            int sum = 0;
            arr[i][0] = num;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            arr[i][1] = sum;
            arr[i][2] = i;
        }
        Arrays.sort(arr , (a,b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        Map<Integer , Integer> map = new HashMap<>();
        for(int[] a : arr){
            map.put(a[0] , a[2]);
        }
        // Set<Integer> seen = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            int target = arr[i][0];
            if(num == target) continue;
            else{
                int tIndex = map.get(arr[i][0]);
                int temp = nums[i];
                nums[i] = target;
                nums[tIndex] = temp;
                map.put(target , i);
                map.put(temp , tIndex);
                count++;
            }
        }
        return count;
    }
}