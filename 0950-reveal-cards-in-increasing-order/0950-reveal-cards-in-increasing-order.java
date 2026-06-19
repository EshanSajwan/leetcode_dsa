class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        int n = deck.length;
        for(int i = n - 1 ; i > -1 ; i--){
            if(q.size() > 1) q.offer(q.poll());
            q.offer(deck[i]);
        }
        int[] ans = new int[n];
        for(int i = n - 1 ; i > -1 ; i--) ans[i] = q.poll();
        return ans;
    }
}