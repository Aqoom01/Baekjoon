#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string solution(string s) {
    string answer = "";
    
    string temp = "";
    vector<int> arr;
    for(int i = 0; i < s.length(); i++) {
        if(s[i] == ' ') {
            arr.push_back({stoi(temp)});
            temp.clear();
        }
        temp += s[i];
    }
    arr.push_back({stoi(temp)});
    
    sort(arr.begin(), arr.end());
    answer += to_string(arr.front());
    answer += " ";
    answer += to_string(arr.back());
    
    return answer;
}