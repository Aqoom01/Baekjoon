class Solution {    
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            
            int a = 10001;
            int b = 10001;
            int c = 10001;
            
            boolean isPlus = false;
            for(String part : parts) {
                if(part.equals("+")) isPlus = true;
                else if(part.equals("-")) isPlus = false;
                else if(part.equals("=")) continue;
                else if(a == 10001) a = Integer.parseInt(part);
                else if(b == 10001) b = Integer.parseInt(part);
                else if(c == 10001) c = Integer.parseInt(part);
            }
            
            if(isPlus) answer[i] = (a + b == c ? "O" : "X");
            else answer[i] = (a - b == c ? "O" : "X");
        }
        
        return answer;
    }
}