#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;
    list<int> L;
    list<int>::iterator iter;

    for (int i = 1; i <= n; i++) {
        L.push_back(i);
    }

    iter = L.begin();

    cout << "<";

    while (L.size() != 0) {
        for (int i = 0; i < k - 1; i++) {
            iter++;
            if (iter == L.end()) {
                iter = L.begin();
            }
        }
        cout << *iter;
        if (L.size() != 1) {
            cout << ", ";
        }
        iter = L.erase(iter);
        if (iter == L.end()) {
            iter = L.begin();
        }
    }
    cout << ">";
}