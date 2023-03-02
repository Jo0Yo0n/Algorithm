#include <iostream>

using namespace std;

int main() {
    int year, answer = 0;

    cin >> year;

    if (year % 4 == 0 && year % 100 != 0) {
        answer = 1;
    } else if (year % 400 == 0) {
        answer = 1;
    }

    cout << answer;
}