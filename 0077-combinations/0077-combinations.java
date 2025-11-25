class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        F(n-1 , k , al);
        return ans;
    }
    void F(int i , int k , List<Integer> al){

        if(al.size() == k) {
            ans.add(new ArrayList<>(al));
            return;
        }

        if(i == -1) return;

        al.add(i+1);
        F(i-1 , k , al);
        al.removeLast();
        F(i-1 , k, al);
    }
}