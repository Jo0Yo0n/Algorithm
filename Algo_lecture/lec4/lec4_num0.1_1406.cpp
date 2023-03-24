#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    list<char> L;
    string str;
    cin >> str;
    for (auto s : str) {
        L.push_back(s);
    }
    list<char>::iterator it = L.end();

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        char userInput;
        cin >> userInput;

        if (userInput == 'L' && it != L.begin()) {
            it--;
        } else if (userInput == 'D' && it != L.end()) {
            it++;
        } else if (userInput == 'B' && it != L.begin()) {
            it--;
            it = L.erase(it);
        } else if (userInput == 'P') {
            char addChar;
            cin >> addChar;
            L.insert(it, addChar);
        }
    }
    for (auto c : L) cout << c;
}