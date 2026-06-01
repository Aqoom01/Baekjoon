class Solution {
    long limit;
    int diffs[], times[];
    
    public long solution(int[] diffs, int[] times, long limit) {
        this.limit = limit;
        this.diffs = diffs;
        this.times = times;
        
        int r = Integer.MIN_VALUE, l = Integer.MAX_VALUE;
        for(int diff : diffs) {
            r = Math.max(r, diff);
            l = Math.min(l, diff);
        }
        
        long answer = r;
        while(l <= r) {
            int mid = (l + r) / 2;
            
            boolean isSolved = solve(mid);
            if(isSolved) {
                answer = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean solve(int level) {
        long result = 0;
        for(int cursor = 0; cursor < this.diffs.length; cursor++) {
            int wrongCnt = Math.max(this.diffs[cursor] - level, 0);
            
            if(cursor == 0) result += (long) wrongCnt * this.times[cursor];
            else result += (long) wrongCnt * (this.times[cursor - 1] + this.times[cursor]);

            result += this.times[cursor];
        }
        
        if(result <= this.limit) return true;
        return false;
    }
}