#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    int answer = 0;
    
    for(int i = 0; i < s.size(); i++) {
        char cur = s[i];
        cout << "X: " << cur << endl;
        
        int X = 1;
        int notX = 0;
        
        int index = i + 1;
        while(X != notX) {
            if(index >= s.size()) break;
            
            cout << s[index] << endl;
            if(s[index] == cur) X++;
            else notX++;
            
            index++;
            i++;
        }
        
        answer += 1;    
    }
    
    return answer;
}