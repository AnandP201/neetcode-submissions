class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int l = 0, r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / n;
            int col = mid % n;

            if (target == matrix[row][col]) {
                return true;
            }

            if (target < matrix[row][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
