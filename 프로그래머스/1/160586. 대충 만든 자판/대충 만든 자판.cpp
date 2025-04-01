#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int dp[27] = {};

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    
    fill(dp, dp + 27, 101);
    
    for(int i = 0; i < keymap.size(); i++) {
        for(int j = 0; j < keymap[i].size(); j++) {
            char cur = keymap[i][j];
            int temp = cur - '0';
            temp -= 16;
            
            if(dp[temp] > j + 1) {
                dp[temp] = j + 1;
            }
        }
    }
    
    for(int i = 0; i < targets.size(); i++) {
        int subAnswer = 0;
        bool possible = true;
        for(int j = 0; j < targets[i].size(); j++) {
            char cur = targets[i][j];
            int temp = cur - '0';
            temp -= 16;
            
            if(dp[temp] == 101) possible = false;
            subAnswer += dp[temp];
        }
        if(possible) answer.push_back(subAnswer);
        else answer.push_back(-1);
    }
    
    return answer;
}