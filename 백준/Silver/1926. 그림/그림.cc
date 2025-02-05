#include <iostream>
#include <queue>
using namespace std;

#define X first
#define Y second

int board[500][500];
bool vis[500][500];
int n, m;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    queue<pair<int, int>> Q;
    int pic = 0;  // 그림의 개수
    int wide = 0;  // 가장 넓은 그림의 넓이
    cin >> n >> m;

    //보드 입력
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> board[i][j];

    //보드 그림 확인
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 1 && vis[i][j] == 0) {  //board[i][j]가 1인 경우
                Q.push({ i, j });
                vis[i][j] = true;
                int area = 1;
                while (!Q.empty()) {
                    pair<int, int> cur = Q.front();
                    Q.pop();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) 
                            continue;
                        if (vis[nx][ny] == 1 || board[nx][ny] != 1) 
                            continue;
                        vis[nx][ny] = 1;
                        area++;
                        Q.push({ nx, ny });
                    }
                }
                if (area > wide)
                    wide = area;
                if (area >= 1)
                    pic++;
            }
            else  // board[i][j] == 0 일 경우 다음 칸으로 넘어감
                continue;
        }
    }

    cout << pic << '\n' << wide << '\n';
    return 0;
}