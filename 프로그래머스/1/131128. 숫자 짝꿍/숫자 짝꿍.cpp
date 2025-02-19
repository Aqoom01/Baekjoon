#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string X, string Y) {
    vector<int> v;
    int Xarr[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int Yarr[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    for(int i = 0; i < X.size(); i++) Xarr[X[i] - '0']++;
    for(int i = 0; i < Y.size(); i++) Yarr[Y[i] - '0']++;
    
    for(int i = 9; i >= 0; i--) {
        if(Xarr[i] > 0 && Yarr[i] > 0) {
            if(Xarr[i] > Yarr[i]) {
                for(int j = 0; j < Yarr[i]; j++) {
                    v.push_back(i);
                }
            }
            else {
                for(int j = 0; j < Xarr[i]; j++) {
                    v.push_back(i);
                }
            }
        }
    }
    
    string answer = "";
    if(v.empty()) return "-1";
    if(v.front() == 0) return "0";    
    for(int i = 0; i < v.size(); i++) {
        answer += (v[i] + '0');
    }
    return answer;
}