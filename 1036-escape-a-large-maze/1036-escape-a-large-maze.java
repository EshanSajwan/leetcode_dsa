class Solution {
    Set<String> set ;
    Set<String> visitSet ;
    int oneM;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length < 2) return true;
        oneM = 1_000_000;
        set = new HashSet<>();
        
        for(int[] co : blocked){
            int i = co[0] , j = co[1];
            set.add(i +" " + j);
        }
        visitSet = new HashSet<>();
        boolean result1 = dfs(source[0] , source[1] , target[0] , target[1] );
        visitSet = new HashSet<>();
        boolean result2 = dfs(target[0] , target[1] , source[0] , source[1] );
        return result1 && result2 ;
    }
    private boolean dfs(int i , int j , int iT , int jT){
        if(i == iT && j == jT) return true;
        if(visitSet.size() > 20_000) return true;
        String str = Integer.toString(i) + " " + Integer.toString(j);
        visitSet.add(str);
        int[] dR = {-1 , 0 , +1 , 0};
        int[] dC = {0 , +1 , 0 , -1};
        for(int x = 0 ; x < 4 ; x++){
            int newR = i + dR[x];
            int newC = j + dC[x];
            String newSTR=Integer.toString(newR) + " " + Integer.toString(newC);
            if(newR < oneM && newR > -1 &&
                newC < oneM && newC > -1 &&
                !set.contains(newSTR) &&
                !visitSet.contains(newSTR))
                {
                    if(dfs(newR , newC , iT , jT)) return true;
                }
        }
        // visitSet.remove(str);
        return false;
    }
}