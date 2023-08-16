#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[53][53];
int vis[53][53];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int t, m, n, k;  // m: 가로길이(열), n: 세로길이(행)

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> t;

    while (t--) {
        cin >> m >> n >> k;

        for (int i = 0; i < n; i++) {  // board, vis 배열 초기화
            for (int j = 0; j < m; j++) {
                board[i][j] = 0;

                vis[i][j] = -1;  // 꼭 -1로 초기화 안해도 됨 -> 0 또는 1만 가지기 때문
            }
        }

        for (int i = 0; i < k; i++) {
            int x, y;

            cin >> y >> x;  // 문제에서 주어진 좌표는 {열, 행} 순서라서 입력을 반대로 받음

            board[x][y] = 1;
        }

        int worm = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || vis[i][j] >= 0) continue;

                queue<pair<int, int>> Q;
                vis[i][j] = 1;
                Q.push({i, j});
                worm++;

                while (!Q.empty()) {
                    pair<int, int> cur = Q.front();
                    Q.pop();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (board[nx][ny] == 0 || vis[nx][ny] >= 0) continue;

                        vis[nx][ny] = 1;
                        Q.push({nx, ny});
                    }
                }
            }
        }
        cout << worm << '\n';
    }
}