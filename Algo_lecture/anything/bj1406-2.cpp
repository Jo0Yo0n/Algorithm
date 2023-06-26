#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    list<char> L;
    list<char>::iterator cursor;
    string init;
    cin >> init;

    for (auto i : init) {
        L.push_back(i);
    }

    cursor = L.end();

    int num;
    char op;

    cin >> num;

    while (num--) {
        cin >> op;

        if (op == 'L' && cursor != L.begin()) {
            cursor--;
        } else if (op == 'D' && cursor != L.end()) {
            cursor++;
        } else if (op == 'B' && cursor != L.begin()) {
            cursor--;
            cursor = L.erase(cursor);
        } else if (op == 'P') {
            char x;
            cin >> x;
            L.insert(cursor, x);
        }
    }

    for (auto i : L) {
        cout << i;
    }
    cout << "\n\n";
}