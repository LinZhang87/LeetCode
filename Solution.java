class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, 
                                    j < triangle.get(i - 1).size() ? dp[i - 1][j] : Integer.MAX_VALUE) + triangle.get(i).get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
