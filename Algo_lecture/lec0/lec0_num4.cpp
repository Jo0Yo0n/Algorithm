#include <iostream>

using namespace std;

int func4(int N) {
    int i;
    for (i = 2; i <= N; i *= 2) {
        continue;
    }
    return i / 2;
}

int main() {
    cout << func4(5) << endl;
    cout << func4(97615282) << endl;
    cout << func4(1024) << endl;
}