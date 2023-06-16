#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int tile[10] = {};
    int num;
    cin >> num;

    while (num != 0) {
        int tmp = num % 10;
        if (tmp == 6) {
            if (tile[6] > tile[9])
                tile[9]++;
            else
                tile[6]++;
        } else if (tmp == 9) {
            if (tile[9] > tile[6])
                tile[6]++;
            else
                tile[9]++;
        } else
            tile[tmp]++;
        num /= 10;
    }

    int max = 0;
    for (auto i : tile) {
        if (max < i) max = i;
    }
    cout << max;
}