#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x = 0, y = 0, m = 0;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> x;

        y += (x / 30) * 10;
        y += 10;  // 기본 요금

        m += (x / 60) * 15;
        m += 15;  // 기본 요금
    }

    if (y < m) {
        cout << "Y"
             << " " << y << '\n';
    } else if (m < y) {
        cout << "M"
             << " " << m << '\n';
    } else {
        cout << "Y M"
             << " " << y << '\n';
    }
}