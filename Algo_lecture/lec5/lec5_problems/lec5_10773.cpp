#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> S;
    int n;
    cin >> n;

    while (n--) {
        int user;
        cin >> user;

        if (user == 0) {
            S.pop();
        } else {
            S.push(user);
        }
    }

    unsigned int sum = 0;
    while (!S.empty()) {
        sum += S.top();
        S.pop();
    }
    cout << sum;
}