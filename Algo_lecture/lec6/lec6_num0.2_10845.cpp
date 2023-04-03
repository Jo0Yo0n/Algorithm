#include <bits/stdc++.h>
using namespace std;

const int MX = 10005;
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

    int n;
    cin >> n;

    while (n--) {
        string op;
        cin >> op;

        if (op == "push") {
            int num;
            cin >> num;
            push(num);
        } else if (op == "pop") {
            if (tail - head == 0) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
                pop();
            }
        } else if (op == "size") {
            cout << tail - head << '\n';
        } else if (op == "empty") {
            if (tail - head == 0) {
                cout << 1 << '\n';
            } else {
                cout << 0 << '\n';
            }
        } else if (op == "front") {
            if (tail - head == 0) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
            }
        } else if (op == "back") {
            if (tail - head == 0) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
            }
        }
    }
}