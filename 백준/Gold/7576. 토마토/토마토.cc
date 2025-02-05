#include <iostream>
#include <queue>
using namespace std;

int board[1000][1000];
int dist[1000][1000];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	cin >> M >> N;
	queue<pair<int, int>> q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1) {
				dist[i][j] = 0;
				q.push({ i, j });
			}
            else dist[i][j] = -1;
		}
	}
	
	while (!q.empty()) {
		pair<int, int> cur = q.front(); q.pop();

		for (int dir = 0; dir < 4; dir++) {
			int newX = cur.first + dx[dir];
			int newY = cur.second + dy[dir];

			if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
				continue;
			}
			if (dist[newX][newY] != -1 || board[newX][newY] == -1) {
				continue;
			}

			dist[newX][newY] = dist[cur.first][cur.second] + 1;
			board[newX][newY] = 1;
            q.push({ newX, newY });
		}
	}


	bool flag = true;
	int date = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 0) flag = false;
			date = max(date, dist[i][j]);
		}
	}

	if (!flag) cout << -1 << endl;
	else cout << date << endl;
}