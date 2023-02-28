#include <iostream>

using namespace std;

int main() {
    int a, b, l = 0;

    cin >> a >> b;

    l = b;
    while (l > 0) {
        cout << a * (l % 10) << endl;
        l /= 10;
    }
    cout << a * b << endl;
}