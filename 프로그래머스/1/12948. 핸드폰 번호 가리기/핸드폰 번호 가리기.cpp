#include <string>
#include <vector>
#include <stack>
using namespace std;

string solution(string phone_number) {
    string answer = "";
    string temp = "";
    
    stack<char> phone_char;
    for(int i = 0; i < phone_number.length(); i++) {
        phone_char.push(phone_number[i]);
    }
    
    int index = 0;
    while(!phone_char.empty()) {
        if(index < 4) {
            temp += phone_char.top();
            phone_char.pop();
        }
        else {
            temp += "*";
            phone_char.pop();
        }
        index++;
    }
    
    for(int i = temp.length() - 1; i >= 0; i--) {
        answer += temp[i];
    }
    
    return answer;
}