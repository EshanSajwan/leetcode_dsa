class Solution {
    
    static int par[];
    static int size[];
    
    public static int findPar(int node){
        if(node == par[node]) return node;
        par[node] = findPar(par[node]);
        return par[node];
    }
    public static void UnionBySize(int node1, int node2){
        int ultPar1 = findPar(node1);
        int ultPar2 = findPar(node2);
        if(size[ultPar1] < size[ultPar2]){
            par[ultPar1] = ultPar2;
            size[ultPar2] +=  size[ultPar1];
        } 
        else // same rank
        {
            par[ultPar2] = ultPar1;
            size[ultPar1] += size[ultPar2];
        }
        return;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        size = new int[n];
        par = new int[n];

        for(int i = 0 ; i < n ; i++){
            size[i] = 1;
            par[i] = i;
        }

        Map<String , Integer> map = new HashMap<>();
        for(int i = 0 ;i < n ; i++){
            for(int j = 1; j < accounts.get(i).size() ; j++){
                if(!map.containsKey(accounts.get(i).get(j))){ // agar nahi hai toh
                    map.put(accounts.get(i).get(j) , i);
                } else { // already kisi se connected hai
                    UnionBySize(i , map.get(accounts.get(i).get(j))); // isko uss se jod do 
                }
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) list.add(new ArrayList<>());
        for(Map.Entry<String , Integer> entry : map.entrySet()){
            String s = entry.getKey();
            int ultPar = findPar(entry.getValue());
            list.get(ultPar).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(list.get(i).size() == 0) continue;
            Collections.sort(list.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String s : list.get(i)) temp.add(s);
            ans.add(temp);
        }
        return ans;
    }
}