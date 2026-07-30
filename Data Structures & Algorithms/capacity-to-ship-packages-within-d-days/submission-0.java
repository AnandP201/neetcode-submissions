class Solution {
    public boolean isFeasible(int weights[], int target, int capacity) {
        int days = 1;
        int sum = 0;
        for (int w : weights) {
            sum += w;
            if (sum > capacity) {
                days++;
                sum = w;
            }
        }
        return days <= target;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;

        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int l = max, r = sum;
        int ans = 0;
        while (l <= r) {
            int capacity = l + (r - l) / 2;

            if (isFeasible(weights, days, capacity)) {
                r = capacity - 1;
                ans = capacity;
            } else {
                l = capacity + 1;
            }
        }

        return ans;
    }
}