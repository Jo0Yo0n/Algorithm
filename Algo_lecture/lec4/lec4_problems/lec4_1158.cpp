#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    list<int> L;
    for (int i = 1; i <= n; i++) {
        L.push_back(i);
    }
    list<int>::iterator iter = L.begin();

    cout << "<";
    while (n--) {
        for (int i = 1; i < k; i++) {
            if (iter == L.end()) {
                iter = L.begin();
            }
            iter++;
            if (iter == L.end()) {
                iter = L.begin();
            }
        }
        if (L.size() != 1) {
            cout << *iter << ", ";
        }
        else{
            cout << *iter;
        }
        iter = L.erase(iter);
    }
    cout << ">";
}