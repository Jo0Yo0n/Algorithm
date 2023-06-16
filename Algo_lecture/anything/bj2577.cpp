#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int answer[10] = {};
    int num, num1, num2, num3;

    cin >> num1 >> num2 >> num3;
    num = num1 * num2 * num3;

    while (num != 0) {
        answer[num % 10]++;
        num = num / 10;
    }

    for (auto i : answer) {
        cout << i << '\n';
    }
}