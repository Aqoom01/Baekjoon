import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] intList = new Integer[numlist.length];
        for(int i = 0; i < numlist.length; i++) intList[i] = numlist[i];
        
        Arrays.sort(intList, (o1, o2) -> {
            if(Math.abs(o1 - n) == Math.abs(o2 - n)) return o2 - o1;
            return Math.abs(o1 - n) - Math.abs(o2 - n);
        });
        
        int[] answer = new int[intList.length];
        for(int i = 0; i < intList.length; i++) {
            answer[i] = intList[i];
        }
        return answer;
    }
}