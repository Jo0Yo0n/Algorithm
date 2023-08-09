#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[503][503];
int vis[503][503];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m, num, area;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 0 || vis[i][j] == 1) continue;
            int a = 0;
            queue<pair<int, int>> Q;
            num++;
            vis[i][j] = 1;
            Q.push({i, j});
            while (!Q.empty()) {
                pair<int, int> cur = Q.front();
                Q.pop();
                a++;
                for (int i = 0; i < 4; i++) {
                    int nx = cur.X + dx[i];
                    int ny = cur.Y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
            if (area < a) area = a;
        }
    }
    cout << num << '\n'
         << area << '\n';
}