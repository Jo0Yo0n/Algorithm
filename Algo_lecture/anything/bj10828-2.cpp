#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> S;

    string op;
    int n, x;
    cin >> n;

    while (n--) {
        cin >> op;
        if (op == "push") {
            cin >> x;
            S.push(x);
        } else if (op == "pop") {
            if (S.size() != 0) {
                cout << S.top() << '\n';
                S.pop();
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "size") {
            cout << S.size() << '\n';
        } else if (op == "empty") {
            if (S.empty())
                cout << "1" << '\n';
            else
                cout << "0" << '\n';
        } else if (op == "top") {
            if (S.empty())
                cout << "-1" << '\n';
            else {
                cout << S.top() << '\n';
            }
        }
    }
}