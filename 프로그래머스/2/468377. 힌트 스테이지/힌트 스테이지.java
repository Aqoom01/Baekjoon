class Solution {
    int[][] cost, hint;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        
        boolean[] output = new boolean[hint.length];
        
        dfs(0, output);
        
        return answer;
    }
    
    public void dfs(int cursor, boolean[] output) {
        if(cursor == output.length) {
            checkCost(output);
            return;
        }
        
        dfs(cursor + 1, output);
        
        output[cursor] = true;
        dfs(cursor + 1, output);
        
        output[cursor] = false;
    }
    
    public void checkCost(boolean[] output) {
        int temp = cost[0][0];
        int n = cost.length;
        int[] getHints = new int[n];

        for (int stage = 1; stage < n; stage++) {
            if (output[stage - 1]) {
                temp += hint[stage - 1][0];

                for (int i = 1; i < hint[stage - 1].length; i++) {
                    int hintStage = hint[stage - 1][i] - 1;
                    getHints[hintStage]++;
                }
            }

            int useHintCount = Math.min(getHints[stage], n - 1);
            temp += cost[stage][useHintCount];
        }

        answer = Math.min(answer, temp);
    }
}