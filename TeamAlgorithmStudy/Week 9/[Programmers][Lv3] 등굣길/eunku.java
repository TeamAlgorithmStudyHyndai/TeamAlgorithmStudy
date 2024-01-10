class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        int[][] arr = new int[n][m];
        int limit = 1000000007;
        for(int i=0; i<puddles.length; i++){
            arr[puddles[i][1]-1][puddles[i][0]-1] =1;
        }
        dp[0][0] = 1;
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(i-1>=0 && j-1>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else if(i-1<0 && j-1>=0){
                    dp[i][j] = dp[i][j-1];
                } else if(i-1>=0 && j-1<0){
                    dp[i][j] = dp[i-1][j];
                }
                dp[i][j] = dp[i][j] % limit;
                if(arr[i][j] == 1){
                    dp[i][j] =0;
                }
            }
        }
        return dp[n-1][m-1];
    }
}