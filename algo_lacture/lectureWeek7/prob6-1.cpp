#include "cstdlib"
#include "ctime"
#include "iostream"
#define itemType int  // key를 나타내기 위한 type
#define infoType int  // node의 번호를 나타내기 위한 type
#define infoNIL -1    // 검색값이 없음을 나타내기 위한 변수
#define itemMIN -1    // head node의 item을 나타내기 위한 변수
#define N 1000
// infoNIL -> NULL과 같음

class BST {
   private:
    struct node {
        itemType key;
        infoType info;
        struct node *l, *r;
        node(itemType k, infoType i, struct node *ll, struct node *rr) {
            key = k;   // node의 key
            info = i;  // node의 번호
            l = ll;    // node의 왼쪽에 연결된 node pointer
            r = rr;    // node의 오른쪽에 연결된 node pointer
        }
    };
    struct node *head, *z;
    int compareCount;  // 비교연산 횟수
    int i;

   public:
    int minLevel, maxLevel, min, max;
    itemType *array;
    BST(int max) {
        minLevel = maxLevel = 0;
        z = new node(0, infoNIL, 0, 0);     //가장 끝의 node를 표현하기 위한 node
        head = new node(itemMIN, 0, z, z);  // root node를 가리키는 head node
        compareCount = 0;
        i = 0;

        array = new itemType[N];
        for (int i = 0; i < N; i++) {
            array[i] = -1;
        }
    }
    ~BST();
    infoType BSTsearch(itemType v);
    void BSTinsert(itemType v, infoType info);
    void inorderTraverse(struct node *t);
    struct node *getHead() {
        return head;
    }
    int getCompareCount() {
        return compareCount;
    }
    void MaxMinLvl();
};

int main() {
    srand(time(NULL));

    // 이진 탐색트리 생성
    BST T1(N);
    int randNum;

    // 랜덤값을 출력
    std::cout << "Random Number list: ";
    for (int i = 0; i < N; i++) {
        randNum = rand() % N;
        std::cout << randNum << ' ';
        T1.BSTinsert(randNum, i);
    }
    std::cout << '\n';

    for (int i = 0; i < N; i++) {
        T1.BSTsearch(i);
    }
    std::cout << "Total count of T1's comparison operation: " << T1.getCompareCount() << '\n';
    std::cout << "The average of T1's comparison operation: " << T1.getCompareCount() / N << '\n'
              << '\n';

    T1.inorderTraverse(T1.getHead()->r);

    // Traverse 결과 출력
    std::cout << "After Traverse Number list: ";
    int i = 0;
    while (T1.array[i] != -1) {
        std::cout << T1.array[i] << ' ';
        i++;
    }
    std::cout << '\n';

    BST T2(N);

    i = 0;
    while (T1.array[i] != -1) {
        T2.BSTinsert(T1.array[i], i);
        i++;
    }

    for (int i = 0; i < N; i++) {
        T2.BSTsearch(i);
    }
    std::cout << "Total count of T2's comparison operation: " << T2.getCompareCount() << '\n';
    std::cout << "The average of T2's comparison operation: " << T2.getCompareCount() / N << '\n'
              << '\n';

    T1.MaxMinLvl();
    std::cout << "Min value of T1: " << T1.min << '\n';
    std::cout << "Level of that value: " << T1.minLevel << '\n';
    std::cout << "Max value of T1: " << T1.max << '\n';
    std::cout << "Level of that value: " << T1.maxLevel << '\n'
              << '\n';
}

infoType BST::BSTsearch(itemType v) {
    struct node *x = head->r;
    z->key = v;

    compareCount++;
    while (v != x->key) {
        x = (v < x->key) ? x->l : x->r;
        compareCount++;
    }
    return x->info;
}

void BST::BSTinsert(itemType v, infoType info) {
    struct node *p, *x;
    p = head;
    x = head->r;

    //새로운 node가 들어갈 위치 찾기
    while (x != z) {
        p = x;
        if (v == x->key) return;  //중복된 값이 있는 경우 삽입하지 않는다.
        x = (v < x->key) ? x->l : x->r;
    }

    // node 삽입
    x = new node(v, info, z, z);
    if (v < p->key)
        p->l = x;
    else
        p->r = x;
}

BST::~BST() {
    delete z, head;
}

void BST::inorderTraverse(struct node *t) {
    if (t != z) {
        inorderTraverse(t->l);
        array[i++] = t->key;
        inorderTraverse(t->r);
    }
}

void BST::MaxMinLvl() {
    struct node *p, *x;

    p = head;
    x = head->r;

    // find Min
    while (x != z) {
        p = x;
        x = x->l;
        minLevel++;
    }
    min = p->key;

    // fine Max
    p = head;
    x = head->r;

    while (x != z) {
        p = x;
        x = x->r;
        maxLevel++;
    }
    max = p->key;
}