class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
        List<Integer> al = new ArrayList<>();
        for(int[] i : intervals){
        
            int count = 0;
            if(al.size() == 0){
                al.add(i[1]);
                al.add(--i[1]);
            }else{
                int left = i[0] , right = i[1];
                for(int x : al) {
                    if(x >= left && x <= right){
                        count++;
                    }
                    if(count == 2) break;
                }
                if(count == 0){
                    al.add(i[1]);
                    al.add(--i[1]);
                } else if(count == 1) al.add(i[1]);
                else continue;
            }
        }
        return al.size();
    }
}