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
        if (cur - 1 >= 0 && dist[cur - 1] == -1) {
            dist[cur - 1] = dist[cur] + 1;
            Q.push(cur - 1);
        }
        if (cur + 1 <= 100000 && dist[cur + 1] == -1) {
            dist[cur + 1] = dist[cur] + 1;
            Q.push(cur + 1);
        }
        if (cur * 2 <= 100000 && dist[cur * 2] == -1) {
            dist[cur * 2] = dist[cur] + 1;
            Q.push(cur * 2);
        }
    }
    cout << dist[k];
}