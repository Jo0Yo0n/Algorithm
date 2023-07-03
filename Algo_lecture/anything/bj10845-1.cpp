#include <bits/stdc++.h>
using namespace std;

const int MX = 50005;
int dat[MX];
int head = 0, tail = 0;

void push(int x) {
    dat[tail++] = x;
}

void pop() {
    head++;
}

int front() {
    return dat[head];
}

int back() {
    return dat[tail - 1];
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
            if (head != tail) {
                cout << front() << '\n';
                pop();
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "size") {
            cout << tail - head << '\n';
        } else if (op == "empty") {
            if (head != tail) {
                cout << 0 << '\n';
            } else {
                cout << 1 << '\n';
            }
        } else if (op == "front") {
            if (head != tail) {
                cout << front() << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "back") {
            if (head != tail) {
                cout << back() << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }
}