#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

vector<int> solution(int n, vector<string> words) {
    map<string, int> appearance;
    appearance[words[0]] = 1;
    for(int count = 1; count < words.size(); count++) {
        string cur = words[count];
        string before = words[count - 1];
        int len_before = before.length();
        
        if(appearance[cur] || before[len_before - 1] != cur[0]) {
            return {count % n + 1, count / n + 1};
        }
        else {
            appearance[cur] = 1;
        }
    }
    
    return {0, 0};
}