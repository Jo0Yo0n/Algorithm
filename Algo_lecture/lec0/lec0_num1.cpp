#include <iostream>

using namespace std;

int func1(int N) {
    int sum = 0;

    for (int i = 1; i <= N; i++) {
        if (i % 3 == 0) sum += i;
        else if (i % 5 == 0) sum += i;
    }

    return sum;
}

int main(){
    cout << func1(16) << endl;
    cout << func1(34567) << endl;
    cout << func1(27639) << endl;
}