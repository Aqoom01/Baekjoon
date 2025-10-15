class Solution {
    public int solution(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        int div = 0;
        
        for(int i = small; i >= 1; i--) {
            if(big % i == 0 && small % i == 0) {
                div = i;
                break;
            }
        }
        
        int deno = b / div;
        boolean flag = true;
        while(deno != 1) {
            if(deno % 2 == 0 || deno % 5 == 0) deno = deno % 2 == 0 ? deno / 2 : deno / 5;
            else {
                flag = false;
                break;
            }
        }
        
        return flag ? 1 : 2;
    }
}