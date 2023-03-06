#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c, result, t;
    int arr[10] = {};

    cin >> a >> b >> c;

    result = a * b * c;

    while (result > 0) {
        arr[result % 10]++;
        result /= 10;
    }
    
    for(auto i:arr){
        cout << i << '\n';
    }
}