#include <cstdlib>
#include <ctime>
#include <iostream>
#define itemType int

using namespace std;

inline void swap(itemType a[], int i, int j) {
    itemType temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

class PQ {
   private:
    itemType *a;
    int N;
    int compareCount;

   public:
    PQ(int max) {
        a = new itemType[max];
        N = max;
        compareCount = 0;
    }
    ~PQ() {
        delete a;
    }

    void randInit();
    void printPQ();
    void heapSort();
    void makeHeap(itemType a[], int root, int lastNode);
    int getCompareCount();
    void setCompareCountZero();
};

int main() {
    srand(time(NULL));
    PQ priorityQueue(10000);  //노드의 개수를 10개로 초기화
    priorityQueue.randInit();
    cout << "Initial state" << '\n';
    priorityQueue.printPQ();

    priorityQueue.heapSort();
    cout << "After heapSort" << '\n';  //최대힙을 이용해서 오름차순 정렬
    priorityQueue.printPQ();

    cout << "Print compareCount at random data: " << priorityQueue.getCompareCount() << '\n'
         << '\n';

    priorityQueue.setCompareCountZero();  //비교연산 횟수 초기화

    // 힙정렬이 최대 비교연산을 하는 경우는 heap을 만들 때, 모든 노드가 leaf까지 비교를 하는 경우.
    // 즉, 최대힙일 경우 오름차순 정렬, 최소힙일 경우 내림차순 정렬인 데이터가 주어졌을 때 최대 비교 연산을 한다.
    // heapSort() 실행 이후 데이터는 오름차순 정렬이 되어 있으므로, 해당 데이터에 다시 한 번 heapSort()를 실행한다.
    priorityQueue.heapSort();
    cout << "After heapSort again" << '\n';
    priorityQueue.printPQ();

    cout << "Print compareCount at ascending data: " << priorityQueue.getCompareCount() << '\n';
}

void PQ::randInit() {
    for (int i = 0; i < N; i++) {
        a[i] = rand() % 1000;
    }
    cout << '\n';
}

void PQ::printPQ() {
    for (int i = 0; i < N; i++) {
        printf("%5d ", a[i]);
    }
    cout << '\n';
}

void PQ::heapSort() {
    int i;
    for (i = N / 2; i >= 1; i--) {  //작은 부분 트리부터 heap을 완성시켜나감
        makeHeap(a, i - 1, N - 1);
        compareCount++;
    }
    compareCount++;

    for (i = N - 1; i >= 1; i--) {
        compareCount++;
        swap(a, 0, i);
        makeHeap(a, 0, i - 1);
    }
    compareCount++;
}

void PQ::makeHeap(itemType a[], int root, int lastNode) {
    int parent, leftSon, rightSon, son, rootValue;
    parent = root;
    rootValue = a[root];
    leftSon = parent * 2 + 1;
    rightSon = leftSon + 1;

    while (leftSon <= lastNode) {
        compareCount++;

        if ((rightSon <= lastNode) && (a[leftSon] < a[rightSon])) {
            son = rightSon;
        } else {
            son = leftSon;
        }
        compareCount += 2;

        if (rootValue < a[son]) {
            a[parent] = a[son];
            parent = son;
            leftSon = parent * 2 + 1;
            rightSon = leftSon + 1;
        } else
            break;
        compareCount++;
    }
    compareCount++;

    a[parent] = rootValue;
}

int PQ::getCompareCount() {
    return compareCount;
}

void PQ::setCompareCountZero() {
    compareCount = 0;
}