class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (map.containsKey(pre - k)) {
                cnt = cnt + map.get(pre - k);   
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}