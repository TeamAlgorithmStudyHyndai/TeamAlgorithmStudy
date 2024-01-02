class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        int[] dp = new int[len];
        
        if (len == 1)
            return sticker[0];
        
        // 1. 처음 스티커 O
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);
        for(int i = 2; i < len ; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = dp[len - 2];     
        // 2. 처음 스티커 X
        dp = new int[len];
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2; i < len ; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        answer = Math.max(answer, dp[len - 1]);
        return answer;
    }
}
