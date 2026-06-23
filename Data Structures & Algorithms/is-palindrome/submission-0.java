class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
    
        String t = s.toLowerCase();

        while (i < j) {
            char l = t.charAt(i);
            char r = t.charAt(j);

            // System.out.println(l + " " + r);

            if (!(Character.isLetter(l) || Character.isDigit(l))) {
                i++;
                continue;
            }
            if (!(Character.isLetter(r) || Character.isDigit(r))) {
                j--;
                continue;
            }

            if (l != r)
                return false;

            i++;
            j--;
        }

        return true;
    }
}
