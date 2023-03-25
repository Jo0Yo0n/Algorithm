#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    list<char> L;
    list<char>::iterator iter;

    string initial;
    cin >> initial;

    for (auto c : initial) {
        L.push_back(c);
    }

    iter = L.end();

    int n;
    cin >> n;

    while (n--) {
        char op;
        cin >> op;

        if (op == 'L' && iter != L.begin()) {
            iter--;
        } else if (op == 'D' && iter != L.end()) {
            iter++;
        } else if (op == 'B' && iter != L.begin()) {
            iter--;
            iter = L.erase(iter);
        } else if (op == 'P') {
            char input;
            cin >> input;

            L.insert(iter, input);
        }
    }

    for (auto c : L) {
        cout << c;
    }
    cout << '\n';
}