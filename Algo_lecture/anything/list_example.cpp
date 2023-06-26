#include <bits/stdc++.h>
using namespace std;

int main() {
    list<int> L = {1, 2};
    list<int>::iterator t = L.begin();
    L.push_front(10);
    cout << *t << '\n';
    L.push_back(5);
    L.insert(t, 6);  // t가 가리키는 곳 앞에 삽입
    t++;
    t = L.erase(t);  // t가 가리키는 값을 제거, 그 다음 원소의 위치를 반환

    cout << *t << '\n';
    for (auto i : L) cout << i << ' ';
    cout << '\n';
    for (list<int>::iterator it = L.begin(); it != L.end(); it++)
        cout << *it << ' ';
}