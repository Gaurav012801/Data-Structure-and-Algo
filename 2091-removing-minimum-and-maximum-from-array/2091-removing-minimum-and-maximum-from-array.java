class Solution {

    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        // Find minimum and maximum indexes
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Make minIndex the smaller index
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Case 1: Delete both from the left
        int fromLeft = right + 1;

        // Case 2: Delete both from the right
        int fromRight = n - left;

        // Case 3: Delete smaller index from left
        // and larger index from right
        int fromBoth = (left + 1) + (n - right);

        return Math.min(fromLeft, Math.min(fromRight, fromBoth));
    }
}