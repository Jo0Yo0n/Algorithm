#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string sentence;

    while (1) {
        stack<char> S;
        int no_flag = 0;

        getline(cin, sentence);
        if (sentence == ".") break;

        for (auto i : sentence) {
            if (i == '(' || i == '[') {
                S.push(i);
            } else if (i == ')') {
                if (S.empty()) {
                    cout << "no" << '\n';
                    no_flag = 1;
                    break;
                } else if (S.top() == '[') {  // stack이 empty일 때 top을 하면 런타임 에러
                    cout << "no" << '\n';
                    no_flag = 1;
                    break;
                } else if (S.top() == '(') {
                    S.pop();
                }
            } else if (i == ']') {
                if (S.empty()) {
                    cout << "no" << '\n';
                    no_flag = 1;
                    break;
                } else if (S.top() == '(') {
                    cout << "no" << '\n';
                    no_flag = 1;
                    break;
                } else if (S.top() == '[') {
                    S.pop();
                }
            }
        }
        if (no_flag != 1 && !S.empty()) {
            cout << "no" << '\n';
        } else if (no_flag != 1) {
            cout << "yes" << '\n';
        }
    }
}