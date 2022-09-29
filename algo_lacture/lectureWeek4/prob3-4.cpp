#include <cstdlib>
#include <ctime>
#include <iostream>
#define itemType int
#define N 1000

using namespace std;

//각 algorithm의 sorting 과정에서 데이터의 위치교환에 따른 이동한 물건의 무게의 합을
//저장하기 위한 전역 변수 선언
int insertSum, quickSum, heapSum;

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
    itemType a[N], a_copy_1[N], a_copy_2[N], a_copy_3[N];

    // 랜덤 배열 생성 및 출력
    cout << "Generated data: ";
    for (i = 0; i < N; i++) {
        a[i] = rand() % 1000;
        printf("%5d ", a[i]);
    }
    cout << '\n'
         << '\n';

    //세 sorting algorithm에서 같은 배열을 사용하기 위해 a[]를 복제
    for (i = 0; i < N; i++) {
        a_copy_1[i] = a[i];
        a_copy_2[i] = a[i];
        a_copy_3[i] = a[i];
    }

    // 3가지 sorting algorithm에서 데이터의 위치 교환에 따른 이동한 물건의 무게의 합
    cout << "<<Insertion Sort>>" << '\n';
    insertion(a_copy_1, N);
    cout << "sum: " << insertSum << '\n';
    for (i = 0; i < N; i++) {
        printf("%5d ", a_copy_1[i]);
    }
    cout << '\n'
         << '\n';

    cout << "<<Quick Sort>>" << '\n';
    quickSort(a_copy_2, 0, N - 1);
    cout << "sum: " << quickSum << '\n';
    for (i = 0; i < N; i++) {
        printf("%5d ", a_copy_2[i]);
    }
    cout << '\n'
         << '\n';

    // 최대힙을 사용한다고 가정
    cout << "<<Heap Sort>>" << '\n';
    heapSort(a_copy_3, N);
    cout << "sum: " << heapSum << '\n';
    for (i = 0; i < N; i++) {
        printf("%5d ", a_copy_3[i]);
    }
    cout << '\n'
         << '\n';
}

void insertion(itemType a[], int n) {
    int i, j;
    itemType v;

    for (i = 1; i < n; i++) {  // 두 번째 원소부터 시작해서 그 앞의 원소들과 비교해서
        v = a[i];              // 삽입 위치 지정 후, 다음 원소로 이동
        j = i;
        while (j >= 1 && a[j - 1] > v) {
            insertSum += v;         // 가벼운 것 든다.
            insertSum += a[j - 1];  // 무거운 것 옮긴다.
            insertSum += v;         // 가벼운 것 옮긴다.
            a[j] = a[j - 1];
            j--;
        }
        insertSum += a[j];
    }
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
        v = a[l];  // pivot
        i = l;
        j = r + 1;
        for (;;) {
            while (a[++i] < v)
                ;
            while (a[--j] > v)
                ;
            if (i >= j) break;

            quickSum += a[j];  //가벼운 것을 먼저 내려놓고,
            quickSum += a[i];  //무거운 것을 빈자리로 이동하고
            quickSum += a[j];  //가벼운 것을 무거운 것이 있던 빈 자리로 이동한다.
            swap(a, i, j);
        }

        quickSum += a[j];
        quickSum += a[i];
        quickSum += a[j];
        swap(a, j, l);  // pivot과 j의 자료 변경
    }

    return j;
}

void heapSort(itemType a[], int n) {
    int i;
    for (i = n / 2; i > 0; i--) {
        makeHeap(a, i - 1, n - 1);  //정렬할 배열을 heap으로 변환. index가 0부터 시작하기 때문에 전체적으로 index에 -1을 해줌.
    }
    for (i = n - 1; i > 0; i--) {
        heapSum += a[i];
        heapSum += a[0];
        heapSum += a[i];
        swap(a, 0, i);          // root 노드와 마지막 노드의 위치를 바꿈
        makeHeap(a, 0, i - 1);  // 남은 원소로 다시 heap 재정비 (최상단 노드부터 heap으로 변환. heap의 크기는 -1. 결과는 오름차순 정렬.)
    }
}

void makeHeap(int a[], int root, int lastNode) {
    int parent, leftSon, rightSon, son, rootValue;
    parent = root;
    rootValue = a[root];
    leftSon = 2 * parent + 1;  // root의 index가 0부터 시작하기 때문
    rightSon = leftSon + 1;

    while (leftSon <= lastNode) {  //반복문 진행하다 보면 son의 index값이 lastNode보다 커지게 되는데, 이를 예방하기 위한 조건
        if ((rightSon <= lastNode) && (a[leftSon] < a[rightSon])) {
            son = rightSon;  // child 중 큰 것을 골라 son에 넣음
        } else
            son = leftSon;

        if (rootValue < a[son]) {  // root값 보다 son값이 더 크면
            heapSum += rootValue;  //부모노드와 자식노드를 교환하는 과정에서 무게의 합 계산
            heapSum += a[son];
            heapSum += rootValue;

            a[parent] = a[son];        // son을 위로 올림 -> 최대힙 (a[parent] 값은 rootValue에 저장되어 있음)
            parent = son;              // son이 parent가 됨
            leftSon = parent * 2 + 1;  // child 다시 지정
            rightSon = leftSon + 1;
        } else
            break;
    }
    a[parent] = rootValue;
}