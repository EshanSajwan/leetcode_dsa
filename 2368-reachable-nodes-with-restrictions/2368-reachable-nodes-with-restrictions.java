class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> res = new HashSet<>();
        for(int i : restricted) res.add(i);
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) tree.add(new ArrayList<>());
        for(int[] e : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        int[] visit = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int curr = q.poll();
                for(int vx : tree.get(curr)){
                    if(visit[vx] == 0 && !res.contains(vx)) {
                        q.offer(vx);
                        visit[vx] = 1;
                    }
                }
            }
        }
        int count = 0;
        for(int i : visit) count += i;
        return count;
    }
}