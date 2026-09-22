class Solution {
    List<List<Integer>> tree;
    int[] good;
    int[] dp;  // Tere findScore ka bottom-up result
    int[] ans; // Tere getScore ka final array

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        this.good = good;
        this.tree = new ArrayList<>();
        this.dp = new int[n];
        this.ans = new int[n];

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        // Pass 1: 0 ko root maan kar neeche ki taraf ka score nikal lo
        dfs1(0, -1);

        // Pass 2: Upar se parent ka score neeche propagate kar do
        dfs2(0, -1, 0);

        return ans;
    }

    // Tera original findScore logic (sirf neeche wale children ke liye)
    private void dfs1(int u, int parent) {
        dp[u] = good[u] == 1 ? 1 : -1;
        for (int v : tree.get(u)) {
            if (v == parent) continue; // Wapas parent par mat jao (No infinite loop)
            dfs1(v, u);
            if (dp[v] > 0) {
                dp[u] += dp[v]; // if (currScore > 0) res += currScore;
            }
        }
    }

    // Loop hatane ki trick: Parent ka contribution upar se le aao
    private void dfs2(int u, int parent, int parentContrib) {
        // Is node ka final answer (Tera getScore) = iska apna sub-tree + parent se aane wala contribution
        ans[u] = dp[u] + parentContrib;

        for (int v : tree.get(u)) {
            if (v == parent) continue;

            // v ko chhod kar, u ka baki pura score kya banta hai?
            int u_without_v = ans[u] - (dp[v] > 0 ? dp[v] : 0);

            // Ye bacha hua score 'v' ke liye parent contribution ban jayega
            int nextParentContrib = Math.max(0, u_without_v); 

            dfs2(v, u, nextParentContrib);
        }
    }
}