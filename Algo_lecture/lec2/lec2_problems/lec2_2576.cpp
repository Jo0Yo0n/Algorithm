#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int x, sum = 0, odd = 0, min = 100;

    for (int i = 0; i < 7; i++) {
        cin >> x;
        if (x & 1) {
            odd++;
            sum += x;

            if (x < min) {
                min = x;
            }
        }
    }

    if (odd) {
        cout << sum << '\n'
             << min << '\n';
    } else
        cout << -1 << '\n';
}