#include <iostream>

using namespace std;

const int N = 10000;

int main() {
    int i, j, a[N + 1];
    long count = 0;

    //* index 범위: 1-N
    //* N 이하의 수를 모두 prime number라고 가정한다.
    for (a[1] = 0, i = 2; i <= N; i++) {
        a[i] = 1;
    }

    //* prime number 판별법: Prime number는 1과 자기 자신만을 인수로 갖는 수이다.
    //* 따라서 두 수의 곱으로 만들어진 수는 prime number가 아니다.
    //* N보다 작은 수 중에서 prime number가 아닌 것을 제외하면 prime number만 남게 된다.

    //* prime number 확인 과정: 배열 인덱스에 저장된 값이 1이면 prime number,
    //* 0이면 non prime number
    //* j <= N / i 인 이유 -> i * j의 값이 N 이하가 되도록 하기 위함
    for (i = 2; i <= N / 2; i++) {
        for (j = 2; j <= N / i; j++) {  //* j=2인 이유: j=1이면, i가 prime number일 때, 소수가 아닌 것으로 분류하게 됨.
            a[i * j] = 0;
            count++;  //* 곱셈 연산 횟수 증가
        }
    }
    //* 배열에 저장된 값이 1인(prime number임이 확인된) 인덱스 중, 가장 큰 인덱스를 출력
    for (i = N; i >= 1; i--) {
        if (a[i]) {
            cout << i;
            break;
        }
    }
    cout << "\n"
         << "count: " << count << '\n';
}