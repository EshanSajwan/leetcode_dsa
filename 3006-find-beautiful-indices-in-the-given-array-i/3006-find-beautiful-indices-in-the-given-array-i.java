class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aInd = findAllOcc(s , a) , 
                      bInd = findAllOcc(s , b) ,
                      ans = new ArrayList<>() ;
        for(int i : aInd){
            for(int j : bInd){
                if(Math.abs(j - i) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;    
    }
    private List<Integer> findAllOcc(String s , String tar){
        List<Integer> al = new ArrayList<>();
        int i = s.indexOf(tar);
        while(i != -1){
            al.add(i);
            i = s.indexOf( tar , i + 1);
        }
        return al;
    }
}