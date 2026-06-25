class Solution {
    boolean isFeasible(int[] piles, int h, int k) {
        int hoursTaken = 0;

        for (int pile : piles) {
            hoursTaken += Math.ceil((double) pile / k);
        }

        return hoursTaken <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int r = 0, l = 0;

        for (int pile : piles) {
            r = Math.max(pile, r);
            l = Math.min(pile, l);
        }

        int ans = 0;

        while (l <= r) {
            int k = l + (r - l) / 2;

            if (isFeasible(piles, h, k)) {
                ans = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return ans;
    }
}
