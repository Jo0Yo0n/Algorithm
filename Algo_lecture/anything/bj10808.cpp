#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string input;
    vector<int> v(26);

    cin >> input;

    for (auto i : input) {
        v[i - 'a']++;
    }

    for(auto i : v){
        cout << i << ' ';
    }
}