class Solution {    
    public String solution(String polynomial) {
        int x = 0;
        int cons = 0;
        
        int temp = 0;
        boolean coeff = false;
        for(int i = 0; i < polynomial.length(); i++) {
            char cur = polynomial.charAt(i);
            
            if(cur == '+') {
                if(coeff) x += temp;
                else if(!coeff) cons += temp;
                
                temp = 0;
                coeff = false;
            }
            else if(cur == 'x') {
                coeff = true;
                if(temp == 0) temp = 1;
            }
            else if(cur == ' ') continue;
            else {
                if(temp != 0) temp *= 10;
                
                temp += cur - '0';
            }
        }
        
        if(coeff) x += temp;
        else if(!coeff) cons += temp;
        
        if (x != 0 && cons != 0) return (x == 1 ? "x" : x + "x") + " + " + cons;
        else if (x == 0 && cons != 0) return String.valueOf(cons);
        else if (x != 0 && cons == 0) return (x == 1 ? "x" : x + "x");
        else return "0";
    }
}