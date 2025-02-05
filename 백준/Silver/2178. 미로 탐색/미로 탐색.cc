#include <iostream>
#include <queue>
using namespace std;

int board[100][100];
int vis[100][100];
int Vx[] = {1, 0, -1, 0};
int Vy[] = { 0, 1, 0, -1 };

int main() {
	int N, M;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int tmp = getchar();
			if (tmp == '\n')
				tmp = getchar();
			board[i][j] = tmp - 48;
		}
	}

	int move = 0;
	queue<pair<pair<int, int>, int>> Q;
	Q.push({{ 0, 0 }, 1});
	vis[0][0] = 1;
	bool flag = true;
	while (flag) {
		int cur_x = Q.front().first.first;
		int cur_y = Q.front().first.second;
		int cur_move = Q.front().second;
		Q.pop();
		if (cur_x == N - 1 && cur_y == M - 1) {
			break;
		}
		else {
			for (int i = 0; i < 4; i++) {
				int new_x = cur_x + Vx[i];
				int new_y = cur_y + Vy[i];

				if (new_x == N - 1 && new_y == M - 1) {
					move = cur_move + 1;
					flag = false;
					break;
				}
				else if (new_x >= 0 && new_x <= N - 1 && new_y >= 0 && new_y <= M - 1 && vis[new_x][new_y] == 0 && board[new_x][new_y] == 1) {
					Q.push({ {new_x, new_y}, cur_move + 1 });
					vis[new_x][new_y] = 1;
				}
			}
		}
	}

	cout << move << endl;
}