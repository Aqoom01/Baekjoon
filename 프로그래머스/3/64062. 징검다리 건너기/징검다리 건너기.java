import java.util.*;

class Solution {
    int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE, stones[], k;
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        this.stones = stones;
        this.k = k;
        for(int stone : stones) {
            l = Math.min(stone, l);
            r = Math.max(stone, r);
        }
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(ride(mid)) {
                answer = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
    
    boolean ride(int mid) {
        int[] temp = this.stones.clone();
        int dist = 0;
        int tmpDist = 0;
        for(int i = 0; i < temp.length; i++) {
            temp[i] -= mid;
            
            if(temp[i] <= 0) {
                tmpDist++;
                dist = Math.max(tmpDist, dist);
            }
            else {
                tmpDist = 0;
            }
        }
        
        return dist >= k;
    }
}