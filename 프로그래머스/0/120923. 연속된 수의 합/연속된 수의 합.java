import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        boolean even = num % 2 == 0 ? true : false;
        
        int base = total / num;
        int start = even ? base - (num / 2 - 1) : base - (int) Math.floor(num / 2);
        
        int[] answer = new int[num];
        for(int i = 0; i < num; i++) {
            answer[i] = start++;
        }
        
        return answer;
    }
}