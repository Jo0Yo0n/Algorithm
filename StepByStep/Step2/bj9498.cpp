#include <iostream>

using namespace std;

int main() {
    int test;

    cin >> test;

    if (test >= 90) {
        cout << "A" << endl;
    } else if (test >= 80) {
        cout << "B" << endl;
    } else if (test >= 70) {
        cout << "C" << endl;
    } else if (test >= 60) {
        cout << "D" << endl;
    } else {
        cout << "F" << endl;
    }
}