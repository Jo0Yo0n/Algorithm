#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x, ans = 0;
    vector<int> a;
    vector<int> occur(2000001);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        a.push_back(tmp);
    }
    cin >> x;

    for (auto i : a) {
        if (x - i > 0 && occur[x - i] == 1) ans++;
        occur[i] = 1;
    }
    cout << ans << '\n';
}