class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] primes = {
            2, 3, 5, 7,
            11, 13, 17, 19,
            23, 29,
            31, 37,
            41, 43, 47,
            53, 59,
            61, 67,
            71, 73, 79,
            83, 89,
            97
        };
        Set<Integer> prime = new HashSet<>();
        for(int i : primes) prime.add(i);
        int numF[] = new int[101];
        for(int i : nums) numF[i]++;
        for(int i : numF) if(prime.contains(i)) return true;
        return false;
    }
}