#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
    stack<int> st;
    bool flag = true;
    for(int i = 0; i < s.size(); i++) {
        if(s[i] == '(') st.push(1);
        if(s[i] == ')') {
            if(st.empty()) {
                flag = false;
                break;
            }
            st.pop();
        }
    }

    if(!st.empty() || !flag) return false;
    return true;
}