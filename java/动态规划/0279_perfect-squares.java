class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minCount = Math.min(minCount, f[i - j * j]);
            }
            f[i] = minCount + 1;
        }
        return f[n];
    }
}