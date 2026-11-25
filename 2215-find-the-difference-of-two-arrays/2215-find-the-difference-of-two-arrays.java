class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>() ,
                    set2 = new HashSet<>() ;
        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al1 = new ArrayList<>() ,
                    al2 = new ArrayList<>() ;
        for(int i : set1){
            if(!set2.contains(i)) al1.add(i);
        }
        for(int i : set2){
            if(!set1.contains(i)) al2.add(i);
        }
        ans.add(al1);
        ans.add(al2);
        return ans;
    }
}