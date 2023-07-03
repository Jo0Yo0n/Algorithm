#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<int> DQ;
    int n, m, count = 0;

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        DQ.push_back(i);
    }

    while (m--) {
        int target, c = 0, temp_count, flag;  // flag가 0이면 왼쪽, 1이면 오른쪽 회전
        cin >> target;

        deque<int>::iterator iter = DQ.begin();

        while (*iter != target) {
            iter++;
            c++;
        }

        if (c > DQ.size() - c) {
            temp_count = DQ.size() - c;
            flag = 1;
        } else {
            temp_count = c;
            flag = 0;
        }
        count += temp_count;

        while (temp_count--) {
            if (flag == 0) {
                DQ.push_back(DQ.front());
                DQ.pop_front();
            } else if (flag == 1) {
                DQ.push_front(DQ.back());
                DQ.pop_back();
            }
        }
        DQ.pop_front();
    }
    cout << count;
}