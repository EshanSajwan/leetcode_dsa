class Solution {
    boolean[] visit , path , safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        visit = new boolean[graph.length];
        path = new boolean[graph.length];
        safe = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ;i++){
            if(!visit[i]) dfs(i , graph);
        }
        List<Integer> list= new ArrayList<>();
        for(int i = 0 ; i < safe.length ; i++) if(safe[i]) list.add(i);
        return list;
    }

    boolean dfs(int i , int[][] graph){
        visit[i] = path[i] = true;
        safe[i] = false;

        for(int vx : graph[i]){
            if(!visit[vx]){
                if(dfs(vx , graph)){ // if true cycle found
                    safe[i] = false; // cycle fount so its unsafe
                    return true;// cycle found
                }
            }
            // isse niche aya matlab visited hai
            if(path[vx]) // path visited bhi hai : cycle found
            {
                safe[i] = false;
                return true;
            }

        } 
        // yaha agaya matlab cycle detect hi nahi hui
        // so its safe
        safe[i] = true;
        path[i] = false;
        return false;// no cycle
    }
}