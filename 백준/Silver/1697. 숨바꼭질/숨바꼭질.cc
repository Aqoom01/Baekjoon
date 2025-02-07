#include <iostream>
#include <queue>
using namespace std;

queue<pair<int, int>> Q;
bool vis[200000];

int main() {
    int N, K;
    cin >> N >> K;

    int answer = 0;

    Q.push({ N, 0 });
    while (1) {
        if (N == K) {
            break;
        }
        else {
            int result = Q.front().first;
            int count = Q.front().second;
            Q.pop();

            int val1, val2, val3;
            val1 = (result - 1);
            val2 = (result + 1);
            val3 = (result * 2);

            if (val1 == K) {
                answer = count + 1;
                break;
            }
            else if (val2 == K) {
                answer = count + 1;
                break;
            }
            else if (val3 == K) {
                answer = count + 1;
                break;
            }


            if (val1 >= 0 && vis[val1] == 0) {
                Q.push({ val1, count + 1 });
                vis[val1] = 1;
            }
            if (vis[val2] == 0) {
                Q.push({ val2, count + 1 });
                vis[val2] = 1;
            }
            if (val3 <= 2 * K && vis[val3] == 0) {
                Q.push({ val3, count + 1 });
                vis[val3] = 1;
            }
        }
    }
    std::cout << answer << endl;
}