class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        // find the index closest to x first
        // uske bad index - 1 -> a or index + 1 -> b
        // check and operate 
        int l = 0 , h = nums.length - 1;
        while(l < h){
            int mid = l + (h - l) / 2;
            if(nums[mid] == x) {
                l = mid;
                break;
            }
            else if(nums[mid] < x) l = mid + 1;
            else h = mid - 1;
        }
        int a , b;
        if(nums[l] <= x){
            a = l ;
            b = l + 1;
        }
        // else if(nums[l] < x){
        //     a = l;
        //     b = l + 1;
        // }
        else{
            a = l - 1;
            b = l;
        }
        List<Integer> al = new ArrayList<>();
        while(k-- > 0){
            if(a == -1) al.add(nums[b++]);
            else if(b == nums.length) al.add(nums[a--]);
            else{
                if(Math.abs(nums[a] - x) <= Math.abs(nums[b] - x))
                    al.add(nums[a--]);
                else
                    al.add(nums[b++]);
            }
        }
        Collections.sort(al);
        return al;
    }
}