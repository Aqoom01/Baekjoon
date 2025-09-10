#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> result;
    
    bool out = false;
    map<string, int> appearance;
    int count = 0;
    for(; count < words.size(); count++) {
        if(out) break;
        
        string cur = words[count];
        if(count == 0) {
            appearance.insert({cur, 1});
            continue;
        }
        
        string before = words[count - 1];
        auto itr = appearance.find(cur);
        if(itr == appearance.end()) {
            appearance.insert({cur, 1});
        }
        else {
            out = true;
        }
        
        int len_before = before.length();
        char c_before = before[len_before - 1];
        cout << "before last char: " << c_before << " / current first char: " << cur[0] << endl;
    
        if(c_before != cur[0]) {
            out = true;
        }
    }
    
    cout << "out: " << ((out)? "true" : "false") << endl;
    cout << "count: " << count << endl;
    if(!out) {
        result.push_back(0);
        result.push_back(0);
    }
    else {
        if(count % n == 0) {
            result.push_back(n);
            result.push_back((count / n));
        }
        else {
            result.push_back(count % n);
            result.push_back((count / n) + 1);
        }
    }
    return result;
}