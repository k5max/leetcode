class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int longStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (numSet.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    currStreak = currStreak + 1;
                }

                longStreak = Math.max(currStreak, longStreak);
            }
        }
        return longStreak;
    }
}