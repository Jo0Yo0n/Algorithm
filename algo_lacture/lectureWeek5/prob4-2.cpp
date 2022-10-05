#include <cstdlib>
#include <ctime>
#include <iostream>
#define N 10
#define itemType int

using namespace std;

int compareCount;

inline void swap(itemType a[], int i, int j) {
    itemType temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

void select(itemType a[], int l, int r, int k);
int partition(itemType a[], int l, int r);
void printArray(itemType a[]);

int main() {
    srand(time(NULL));

    itemType a[N], b[N], c[N];  //최소치, 최대치, 중앙치의 비교연산을 비교하기 위해 배열을 복제
    int minCount, maxCount, midCount;
    minCount = maxCount = midCount = 0;

    for (int i = 0; i < N; i++) {  //랜덤 값 대입 및 동기화
        a[i] = rand() % 1000;
        b[i] = c[i] = a[i];
    }
    cout << "<Before Select> " << '\n';
    printArray(a);
    cout << '\n';

    select(a, 0, N - 1, 0);  //최소치
    minCount = compareCount;
    compareCount = 0;

    select(b, 0, N - 1, N - 1);  //최대치
    maxCount = compareCount;
    compareCount = 0;

    select(c, 0, N - 1, (int)((N - 1) / 2));  //중앙치
    midCount = compareCount;
    compareCount = 0;

    cout << "<After Select>" << '\n';
    cout << "Select MIN: ";
    printArray(a);

    cout << "Select MAX: ";
    printArray(b);

    cout << "Select MID: ";
    printArray(c);

    cout << "Min value: " << a[0] << ", Min Count: " << minCount << "\n";
    cout << "Max value: " << b[N - 1] << ", Max Count: " << maxCount << '\n';
    cout << "Mid value: " << c[(int)((N - 1) / 2)] << ", Mid Count: " << midCount << '\n';
}

void select(itemType a[], int l, int r, int k) {
    int j;

    compareCount++;
    if (r > l) {
        j = partition(a, l, r);
        if (j > l + k - 1) select(a, l, j - 1, k);
        if (j < l + k - 1) select(a, j + 1, r, k - j + l - 1);
    }
}
int partition(itemType a[], int l, int r) {
    int i, j;
    itemType v;
    compareCount++;
    if (r > l) {
        v = a[l];
        i = l;
        j = r + 1;

        for (;;) {
            while (a[++i] < v)
                compareCount++;
            compareCount++;

            while (a[--j] > v)
                compareCount++;
            compareCount++;

            compareCount++;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, j, l);
    }
    return j;
}

void printArray(itemType a[]) {
    for (int i = 0; i < N; i++) {
        printf("%5d ", a[i]);
    }
    cout << '\n';
}