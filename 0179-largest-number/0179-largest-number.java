class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i : nums) list.add(String.valueOf(i));
        Collections.sort(list , (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s);
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}