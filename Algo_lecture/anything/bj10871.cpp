#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, X;
    cin >> N >> X;

    vector<int> A;
    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        A.push_back(tmp);
    }

    for (auto i : A) {
        if (i < X) {
            cout << i << ' ';
        }
    }
}