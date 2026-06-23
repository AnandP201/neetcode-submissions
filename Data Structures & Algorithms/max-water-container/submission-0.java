class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;

        int maxArea = 0;

        while (l < r) {

            int area = Math.min(heights[r], heights[l]) * (r - l);
            maxArea = Math.max(area, maxArea);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }

        }

        return maxArea;
    }
}
