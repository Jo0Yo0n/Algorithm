#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
char board[1002][1002];  // 배열을 전역변수로 선언했으므로 0으로 초기화되어 있음
int fire[1002][1002];
int J[1002][1002];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;

int main() {
    cin >> n >> m;
    queue<pair<int, int>> Q;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'F') {
                Q.push({i, j});
            }
            if (board[i][j] == '.' || board[i][j] == 'J') {
                fire[i][j] = -1;
            }
        }
    }

    // 불에 대한 BFS
    while (!Q.empty()) {
        pair<int, int> cur = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (fire[nx][ny] >= 0) continue;
            fire[nx][ny] = fire[cur.X][cur.Y] + 1;
            Q.push({nx, ny});
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 'J') {
                Q.push({i, j});
            }
            if (board[i][j] == '.' || board[i][j] == 'F') {  // 굳이 '#'을 0으로 초기화 할 필요 없었음
                J[i][j] = -1;
            }
        }
    }

    // 지훈이에 대한 BFS
    while (!Q.empty()) {
        pair<int, int> cur = Q.front();
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            // 범위를 벗어났다는 것은 탈출에 성공했다는 의미. 큐에 거리 순으로 들어가므로 최초에 탈출한 시간을 출력하면 됨.
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                cout << J[cur.X][cur.Y] + 1;
                return 0;
            }
            if (J[nx][ny] >= 0) continue;
            if (fire[nx][ny] != -1 && fire[nx][ny] <= J[cur.X][cur.Y] + 1) continue;
            J[nx][ny] = J[cur.X][cur.Y] + 1;
            Q.push({nx, ny});
        }
    }
    cout << "IMPOSSIBLE" << '\n';
}