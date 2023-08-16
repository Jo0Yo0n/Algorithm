#include <bits/stdc++.h>
using namespace std;
int board[100003];
int dist[100003];
int n, k;

int main() {
    cin >> n >> k;

    for (int i = 0; i < 100003; i++) {
        dist[i] = -1;
    }

    queue<int> Q;
    dist[n] = 0;
    Q.push(n);

    while (dist[k] == -1) {
        int cur = Q.front();
        Q.pop();
        for (int dir : {cur - 1, cur + 1, cur * 2}) {
            if (dir < 0 || dir > 100000) continue;
            if (dist[dir] >= 0) continue;
            dist[dir] = dist[cur] + 1;
            Q.push(dir);
        }
    }

    cout << dist[k] << '\n';
}