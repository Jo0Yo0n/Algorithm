#include <bits/stdc++.h>
using namespace std;

int num[10];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int room;
    cin >> room;

    while (room > 0) {
        if (room % 10 != 6 && room % 10 != 9) {
            num[room % 10]++;
            room /= 10;
        } else {
            if (num[6] != num[9]) {
                if (num[6] > num[9])
                    num[9]++;
                else
                    num[6]++;
            } else {
                num[room % 10]++;
            }
            room /= 10;
        }
    }

    int max = 0;
    for (int i = 0; i < 10; i++) {
        if (num[i] > max) max = num[i];
    }

    cout << max;
}