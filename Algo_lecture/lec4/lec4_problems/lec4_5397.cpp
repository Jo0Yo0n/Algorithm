#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        string password;
        cin >> password;

        list<char> L = {};
        list<char>::iterator iter = L.begin();

        for (auto c : password) {
            if (c == '<') {
                if (iter != L.begin())
                    iter--;
            } else if (c == '>') {
                if (iter != L.end())
                    iter++;
            } else if (c == '-') {
                if (iter != L.begin()) {
                    iter--;
                    iter = L.erase(iter);
                }
            } else {
                L.insert(iter, c);
            }
        }

        for (auto c : L) {
            cout << c;
        }
        cout << '\n';
    }
}