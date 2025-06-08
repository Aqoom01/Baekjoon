#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> skipAlpha;

string solution(string s, string skip, int index) {
    for (char c : skip) {
        skipAlpha.push_back(c);
    }

    for (int i = 0; i < s.size(); i++) {
        int cur = (int)s[i];
        int advanced = index;
        while (advanced--) {
            cur += 1;
            if (cur == 123) cur = 97;

            auto it = find(skipAlpha.begin(), skipAlpha.end(), cur);
            if (it != skipAlpha.end()) advanced++;
        }
        s[i] = cur;
    }

    return s;
}