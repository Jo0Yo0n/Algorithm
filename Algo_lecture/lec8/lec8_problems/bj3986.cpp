#include <bits/stdc++.h>
using namespace std;
// ABABBABA
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, count = 0;

    cin >> n;
    while (n--) {
        string word;
        stack<char> S;
        bool isValid = true;

        cin >> word;
        for (auto i : word) {
            if (i == 'A') {
                if (!S.empty() && S.top() == 'A') {
                    S.pop();
                } else {
                    S.push(i);
                }
            } else if (i == 'B') {
                if (!S.empty() && S.top() == 'B') {
                    S.pop();
                } else {
                    S.push(i);
                }
            }
        }
        if (!S.empty()) {
            isValid = false;
        }
        if (isValid) {
            count++;
        }
    }

    cout << count << '\n';
}