#include <bits/stdc++.h>
using namespace std;

const int MAX = 10005;
int dat[MAX];
int pos = 0;

void push(int v) {
    dat[pos++] = v;
}
void pop() {
    pos--;
}
int size() {
    return pos;
}
int top() {
    return dat[pos - 1];
}
bool empty() {
    if (pos == 0)
        return true;
    else
        return false;
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
            int c;
            cin >> c;

            push(c);
        } else if (op == "pop") {
            if (empty())
                cout << -1 << '\n';
            else {
                cout << top() << '\n';
                pop();
            }
        } else if (op == "size") {
            cout << size() << '\n';
        } else if (op == "empty") {
            if (empty())
                cout << 1 << '\n';
            else
                cout << 0 << '\n';
        } else if (op == "top") {
            if (empty())
                cout << -1 << '\n';
            else
                cout << top() << '\n';
        }
    }
}