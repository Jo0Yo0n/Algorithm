#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    for (int i = 1; i <= N - 1; i++) {
        for (int j = 0; j < i; j++) {
            cout << "*";
        }
        for (int j = 1; j <= (N - i) * 2; j++) {
            cout << " ";
        }
        for (int j = 0; j < i; j++) {
            cout << "*";
        }
        cout << '\n';
    }

    for (int j = 1; j <= 2 * N; j++) {
        cout << "*";
    }
    cout << '\n';

    for (int i = N - 1; i >= 1; i--) {
        for (int j = 0; j < i; j++) {
            cout << "*";
        }
        for (int j = 1; j <= (N - i) * 2; j++) {
            cout << " ";
        }
        for (int j = 0; j < i; j++) {
            cout << "*";
        }
        cout << '\n';
    }
}