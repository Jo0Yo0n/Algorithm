#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
int dat[MX * 2 + 1];
int head = MX, tail = MX;

void push_front(int x) {
    dat[--head] = x;
}

void push_back(int x) {
    dat[tail++] = x;
}

void pop_front() {
    head++;
}

void pop_back() {
    tail--;
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
        if (op == "push_front") {
            cin >> x;
            push_front(x);
        } else if (op == "push_back") {
            cin >> x;
            push_back(x);
        } else if (op == "pop_front") {
            if (head != tail) {
                cout << front() << '\n';
                pop_front();
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "pop_back") {
            if (head != tail) {
                cout << back() << '\n';
                pop_back();
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "size") {
            cout << tail - head << '\n';
        } else if (op == "empty") {
            if (tail != head) {
                cout << 0 << '\n';
            } else {
                cout << 1 << '\n';
            }
        } else if (op == "front") {
            if (tail != head) {
                cout << front() << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else if (op == "back") {
            if (tail != head) {
                cout << back() << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }
}