class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String f = strs[0], e = strs[strs.length - 1];

        int idx = 0;

        while (idx < f.length()) {
            if (f.charAt(idx) == e.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        return f.substring(0, idx);
    }
}