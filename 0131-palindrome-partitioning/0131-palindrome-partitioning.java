class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        PP(0 , s , ds , ans);
        return ans;
    }
    void PP(int pointer , String s , List<String> ds , List<List<String>> ans ){

        if(pointer == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = pointer ; i < s.length() ; i++){
            if(isPal(s , pointer , i)){
                ds.add(s.substring(pointer , i+1));
                PP(i+1 , s , ds , ans);
                ds.remove(ds.size()-1);
            }
        }
    }

    boolean isPal(String s , int i , int j){
        while(i <= j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}