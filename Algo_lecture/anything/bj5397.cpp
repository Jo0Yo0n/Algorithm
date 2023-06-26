#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int count;
    cin >> count;

    while (count--) {
        list<char> L;
        list<char>::iterator cursor;

        string log;
        cin >> log;
        cursor = L.end();

        for (auto i : log) {
            if (i == '<') {
                if (cursor != L.begin())
                    cursor--;
            } else if (i == '>') {
                if (cursor != L.end())
                    cursor++;
            } else if (i == '-') {
                if (cursor != L.begin()) {
                    cursor--;
                    cursor = L.erase(cursor);
                }
            } else {
                L.insert(cursor, i);
            }
        }

        for (auto i : L) {
            cout << i;
        }
        cout << '\n';
    }
}