#include <cmath>
#include <iostream>

using namespace std;

int func3(int N) {
    double s = sqrt(N);

    if (s - (int)s == 0)
        return 1;
    else
        return 0;
}

int main() {
    cout << func3(9) << endl;
    cout << func3(693953651) << endl;
    cout << func3(756580036) << endl;
}