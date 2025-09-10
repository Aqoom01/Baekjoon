class Solution {    
    int[] dp;
    int[] dp2;
    
    public int solution(int[] money) {
        int len = money.length;
        dp = new int[len];
        //0번째를 포함한 경우
        dp[0] = money[0];
        int input = Math.max(money[0], money[1]);
        dp[1] = input;
        
        for(int i = 2; i < len-1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        //0번째를 포함하지 않은 경우
        dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = money[1];
        for(int i = 2; i < len; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        return Math.max(dp[len - 2], dp2[len - 1]);
    }
}