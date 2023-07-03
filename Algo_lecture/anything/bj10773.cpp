#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> S;
    int n, x, sum = 0;
    cin >> n;

    while (n--) {
        cin >> x;
        if (x == 0) {
            S.pop();
        } else {
            S.push(x);
        }
    }
    while (!S.empty()) {
        sum += S.top();
        S.pop();
    }
    cout << sum;
}