#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> s;
    vector<char> v;
    vector<int> arr;

    int n;
    cin >> n;
    int i = 1;
    bool flag = true;

    while (n--) {
        int t;
        cin >> t;

        arr.push_back(t);
    }

    for (auto t : arr) {
        if (i <= t) {
            while (i <= t) {
                s.push(i++);
                v.push_back('+');
            }
            if (s.top() == t) {
                v.push_back('-');
                s.pop();
            }
        } else {
            if (s.top() == t) {
                v.push_back('-');
                s.pop();
            } else {
                cout << "NO";
                flag = false;
                break;
            }
        }
    }

    if (flag) {
        for (auto temp : v) {
            cout << temp << '\n';
        }
    }
}