#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[1002];
int Jdist[1002][1002];
int Fdist[1002][1002];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    queue<pair<int, int>> JQ;
    queue<pair<int, int>> FQ;

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> board[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            Jdist[i][j] = -1;
            Fdist[i][j] = -1;

            if (board[i][j] == 'J') {
                Jdist[i][j] = 0;
                JQ.push({i, j});
            }
            if (board[i][j] == 'F') {
                Fdist[i][j] = 0;
                FQ.push({i, j});
            }
        }
    }

    while (!FQ.empty()) {
        pair<int, int> cur = FQ.front();
        FQ.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (board[nx][ny] == '#' || Fdist[nx][ny] >= 0) continue;

            Fdist[nx][ny] = Fdist[cur.X][cur.Y] + 1;
            FQ.push({nx, ny});
        }
    }

    while (!JQ.empty()) {
        pair<int, int> cur = JQ.front();
        JQ.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                cout << Jdist[cur.X][cur.Y] + 1 << '\n';
                return 0;
            }
            if (board[nx][ny] == '#' || Jdist[nx][ny] >= 0) continue;
            if (Fdist[nx][ny] != -1 && Jdist[cur.X][cur.Y] + 1 >= Fdist[nx][ny]) continue;

            Jdist[nx][ny] = Jdist[cur.X][cur.Y] + 1;
            JQ.push({nx, ny});
        }
    }
    cout << "IMPOSSIBLE" << '\n';
}