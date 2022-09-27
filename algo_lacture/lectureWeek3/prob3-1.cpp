#include <cstdlib>
#include <ctime>
#include <iostream>
#define itemType int
#define N 10

using namespace std;

// 각 알고리즘의 비교연산과 자료교환 연산횟수를 count하기 위한 변수
int compareInsert, compareQuick, compareHeap, changeInsert, changeQuick, changeHeap;

inline void swap(itemType a[], int i, int j) {
    itemType t = a[i];
    a[i] = a[j];
    a[j] = t;
}
void insertion(itemType a[], int n);
void quickSort(itemType a[], int l, int r);
int partition(itemType a[], int l, int r);
void heapSort(itemType a[], int n);
void makeHeap(itemType a[], int root, int lastNode);

int main() {
    srand(time(NULL));
    int i, userSelect;
    itemType a[N];

    cout << "data: ";
    for (i = 0; i < N; i++) {
        a[i] = rand() % 1000;
        printf("%5d ", a[i]);
    }
    cout << '\n';

    cout << "1. Insertion Sort, 2. Quick Sort, 3. Heap Sort" << '\n';

    cout << ">> ";
    cin >> userSelect;

    switch (userSelect) {
        case 1:
            insertion(a, N);
            cout << "Compare count: " << compareInsert << " Change count: " << changeInsert << '\n';
            for (i = 0; i < N; i++) {
                printf("%5d ", a[i]);
            }
            cout << '\n';
            break;
        case 2:
            quickSort(a, 0, N - 1);
            cout << "Compare count: " << compareQuick << " Change count: " << changeQuick << '\n';
            for (i = 0; i < N; i++) {
                printf("%5d ", a[i]);
            }
            cout << '\n';
            break;
        case 3:
            heapSort(a, N);
            cout << "Compare count: " << compareHeap << " Change count: " << changeHeap << '\n';
            for (i = 0; i < N; i++) {
                printf("%5d ", a[i]);
            }
            cout << '\n';
            break;
        default:
            cout << "Unknown";
            cout << '\n';
            break;
    }
}

void insertion(itemType a[], int n) {
    int i, j;
    itemType v;

    for (i = 1; i < n; i++) {  //두 번째 원소부터 시작해서 그 앞의 원소들과 비교해서
        v = a[i];              //삽입 위치 지정 후, 다음 원소로 이동
        j = i;
        while (j >= 1 && a[j - 1] > v) {
            compareInsert++;

            a[j] = a[j - 1];
            changeInsert++;

            j--;
        }
        a[j] = v;
    }
    compareInsert++;
}

void quickSort(itemType a[], int l, int r) {
    int j;
    if (r > l) {
        j = partition(a, l, r);
        quickSort(a, l, j - 1);
        quickSort(a, j + 1, r);
    }
}

int partition(itemType a[], int l, int r) {
    int i, j;
    itemType v;
    if (r > l) {
        compareQuick++;
        v = a[l];  // pivot
        i = l;
        j = r + 1;
        for (;;) {
            while (a[++i] < v)
                compareQuick++;
            compareQuick++;
            while (a[--j] > v)
                compareQuick++;
            compareQuick++;

            if (i >= j) {
                compareQuick++;
                break;
            }
            swap(a, i, j);
            changeQuick++;
        }
        swap(a, j, l);  // pivot과 j의 자료 변경
        changeQuick++;
    }

    return j;
}

void heapSort(itemType a[], int n) {
    int i;
    for (i = n / 2; i > 0; i--) {
        makeHeap(a, i - 1, n - 1);  //정렬할 배열을 heap으로 변환. index가 0부터 시작하기 때문에 전체적으로 index에 -1을 해줌.
    }
    for (i = n - 1; i > 0; i--) {
        swap(a, 0, i);  // heap의 최대값을 제거하고 (a[i]와 교환)
        changeHeap++;

        makeHeap(a, 0, i - 1);  //남은 원소로 다시 heap 재정비 (최상단 노드부터 heap으로 변환. heap의 크기는 -1. 결과는 오름차순 정렬.)
    }
}

void makeHeap(int a[], int root, int lastNode) {
    int parent, leftSon, rightSon, son, rootValue;
    parent = root;
    rootValue = a[root];
    leftSon = 2 * parent + 1;  // root의 index가 0부터 시작하기 때문
    rightSon = leftSon + 1;

    while (leftSon <= lastNode) {  //반복문 진행하다 보면 son의 index값이 lastNode보다 커지게 되는데, 이를 예방하기 위한 조건
        compareHeap++;

        if ((rightSon <= lastNode) && (a[leftSon] < a[rightSon])) {
            compareHeap++;
            son = rightSon;  // child 중 큰 것을 골라 son에 넣음
        } else {
            compareHeap++;
            son = leftSon;
        }

        if (rootValue < a[son]) {  // root값 보다 son값이 더 크면
            compareHeap++;

            a[parent] = a[son];        // son을 위로 올림 -> 최대힙 (a[parent] 값은 rootValue에 저장되어 있음)
            parent = son;              // son이 parent가 됨
            leftSon = parent * 2 + 1;  // child 다시 지정
            rightSon = leftSon + 1;
        } else
            break;
    }
    compareHeap++;

    a[parent] = rootValue;
    changeHeap++;
}