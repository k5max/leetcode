class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos2];
        nums[pos2] = nums[pos1];
        nums[pos1] = temp;
    }
}