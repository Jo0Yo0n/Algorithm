#include <bits/stdc++.h>
using namespace std;

int arr[2000001];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x, ans = 0;
    int a[100000];

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> x;

    for (int i = 0; i < n; i++) {
        if (x - a[i] < 0) continue;
        if (arr[x - a[i]] == 1) ans++;
        arr[a[i]]++;
    }

    cout << ans;
}