#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin >> str;

    int arr[26];

    for (int i = 0; i < 26; i++) {
        arr[i] = 0;
    }

    for (auto s : str) {
        arr[s - 'a']++;
    }

    for (auto a : arr) {
        cout << a << " ";
    }
    cout << "\n";
}