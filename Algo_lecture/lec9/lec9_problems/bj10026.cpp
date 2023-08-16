#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[102];
int vis[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int ans1, ans2;

int main() {
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> board[i];
    }

    // 적록색약이 아닌 사람이 봤을 때
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (vis[i][j]) continue;

            queue<pair<int, int>> Q;
            vis[i][j] = 1;
            Q.push({i, j});
            ans1++;

            while (!Q.empty()) {
                pair<int, int> cur = Q.front();
                Q.pop();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[cur.X][cur.Y] != board[nx][ny] || vis[nx][ny]) continue;

                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
        }
    }

    // vis 배열 초기화
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            vis[i][j] = 0;
        }
    }

    // 적록색약인 사람이 봤을 때
    // G를 R로 치환
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == 'G') board[i][j] = 'R';
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (vis[i][j]) continue;

            queue<pair<int, int>> Q;
            vis[i][j] = 1;
            Q.push({i, j});
            ans2++;

            while(!Q.empty()){
                pair<int, int> cur = Q.front();
                Q.pop();

                for (int dir = 0; dir < 4;dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[cur.X][cur.Y] != board[nx][ny] || vis[nx][ny]) continue;

                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
        }
    }

    cout << ans1 << " " << ans2 << '\n';
}