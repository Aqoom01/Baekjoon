#include <iostream>
#include <queue>
using namespace std;

char board[1000][1000];
int moved[1000][1000];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<pair<int, int>> q;
	queue<pair<int, int>> tempQ;
	int R, C;
	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		string input;
		cin >> input;
		for (int j = 0; j < C; j++) {
			board[i][j] = input[j];
			if (board[i][j] == 'J') {
				moved[i][j] = 1;
				q.push({ i, j });
			}
			else if (board[i][j] == 'F') {
				tempQ.push({ i, j });
			}
		}
	}
	while (!tempQ.empty()) {
		q.push(tempQ.front());
		tempQ.pop();
	}

	bool flag = true;
	bool success = false;
	int count = 0;
	while (!q.empty()) {
		if (success) break;

		pair<int, int> cur = q.front(); q.pop();
		if (board[cur.first][cur.second] == 'J') {
            if(cur.first == 0 || cur.first == R - 1 || cur.second == 0 || cur.second == C - 1) {
                success = true;
                count = moved[cur.first][cur.second];
                break;
            }
			for (int dir = 0; dir < 4; dir++) {
				int newX = cur.first + dx[dir];
				int newY = cur.second + dy[dir];

				if (newX < 0 || newX >= R || newY < 0 || newY >= C) {
					continue;
				}
				if (board[newX][newY] == 'F' || board[newX][newY] == '#' || moved[newX][newY] != 0) {
					continue;
				}

				q.push({ newX, newY });
				board[newX][newY] = 'J';
				moved[newX][newY] = moved[cur.first][cur.second] + 1;
				if ((newX == 0 || newX == R - 1 || newY == 0 || newY == C - 1) && 
					(board[newX + 1][newY] != 'F' && board[newX - 1][newY] != 'F' && board[newX][newY + 1] != 'F' && board[newX][newY - 1] != 'F')) {
					success = true;
					count = moved[newX][newY];
				}
			}
		}
		else if (board[cur.first][cur.second] == 'F') {
			
			for (int dir = 0; dir < 4; dir++) {
				int newX = cur.first + dx[dir];
				int newY = cur.second + dy[dir];

				if (newX < 0 || newX >= R || newY < 0 || newY >= C) {
					continue;
				}
				if (board[newX][newY] == 'F' || board[newX][newY] == '#') {
					continue;
				}

				board[newX][newY] = 'F';
				q.push({ newX, newY });
			}

		}
		else {
			flag = false;
			break;
		}
	}
	if (success) cout << count << endl;
	else cout << "IMPOSSIBLE" << endl;
}