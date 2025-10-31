class Solution {
    public int solution(int[] common) {
        int last = common.length - 1;
        
        return common[last] - common[last - 1] == common[last - 1] - common[last - 2] ? common[last] + common[last] - common[last - 1] : common[last] * common[last] / common[last - 1];
    }
}