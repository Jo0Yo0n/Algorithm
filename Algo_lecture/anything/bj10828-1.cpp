#include <bits/stdc++.h>
using namespace std;

const int MX = 10005;
int dat[MX];
int pos = 0;

void push(int x) {
    dat[pos++] = x;
}

int pop() {
    return dat[--pos];
}

int top() {
    return dat[pos - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x;
    string op;

    cin >> n;

    while (n--) {
        cin >> op;
        if (op == "push") {
            cin >> x;
            push(x);
        } else if (op == "pop") {
            if (pos != 0) {
                cout << pop() << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "size") {
            cout << pos << '\n';
        } else if (op == "empty") {
            if (pos == 0) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else if (op == "top") {
            if (pos != 0) {
                cout << top() << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }
}