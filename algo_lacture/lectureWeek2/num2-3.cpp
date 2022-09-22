/**
 * @file num2-3.cpp
 * @author JooYoon Lee (dlwndbs10@gmail.com)
 * @brief n 개의 양의 정수를 random 함수로 발생한 집단을 A라하고, m개의 양의 정수를
 * random 함수로 발생한 집단을 B라 할 때, 2 집단 A와 B의 합집합(Union) U와
 * 교집합(Intersection) X를 결정하고 출력하는 알고리즘을 작성하고 실습하시오. (단, m, b >=10)
 * @version 0.1
 * @date 2022-09-22
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <cstdlib>
#include <ctime>
#include <iostream>
#define MOD 100

using namespace std;

typedef int itemType;

class linkedList {
    struct node {
        int key;
        node* next;
    };

   public:
    linkedList();
    ~linkedList();
    int getSize();
    int getTop();
    void push(itemType key);
    itemType pop();
    void clear();
    void printList();

   private:
    node *header, *top;
    int stackSize;
};

void sortList(linkedList& list, int& Size) {
    linkedList temp;

    for (int i = 0; i < Size; i++) {
        int randNum = (rand() % MOD) + 1;
        while (list.getSize() != 0 && list.getTop() < randNum) {
            temp.push(list.pop());  //기존 stack에서 원소를 빼서 임시 stack에 저장
        }
        if (list.getSize() == 0 || list.getTop() != randNum) {
            list.push(randNum);  // randNum이 있어야 할 위치에 삽입
        }
        while (temp.getSize() != 0) {  //임시 stack에 저장돼 있던 노드들을 원래 리스트로 옮김
            list.push(temp.pop());
        }
    }
}

void getResult(linkedList& A, linkedList& B, linkedList& X) {
    linkedList temp;

    while (B.getSize() != 0) {
        int compare = B.pop();

        while (A.getSize() != 0 && A.getTop() < compare) {
            temp.push(A.pop());
        }
        // 리스트가 비어있거나, Top node의 key가 compare보다 큰 경우 -> compare 삽입
        if (A.getSize() == 0 || A.getTop() > compare) {
            A.push(compare);
        }
        // Top node의 key와 compare가 같은 경우 교집합을 저장하는 리스트인 X에 compare 삽입
        else if (A.getTop() == compare) {
            X.push(compare);
        }
        //임시 stack에 저장돼 있던 노드들을 원래 리스트로 옮김
        while (temp.getSize() != 0) {
            A.push(temp.pop());
        }
    }
}

int main() {
    srand(time(NULL));
    int n, m;
    linkedList A, B, X;

    cout << "A의 원소 개수: ";
    cin >> n;
    cout << "B의 원소 개수: ";
    cin >> m;

    sortList(A, n);
    sortList(B, m);

    //정렬된 리스트 출력
    cout << "A: ";
    A.printList();
    cout << '\n';

    cout << "B: ";
    B.printList();
    cout << '\n'
         << '\n';

    //합집합과 교집합을 구하고 출력
    getResult(A, B, X);

    cout << "U: ";
    A.printList();
    cout << '\n';

    cout << "X: ";
    X.printList();
    cout << '\n';
}

linkedList::linkedList() {
    header = nullptr;
    top = nullptr;
    stackSize = 0;
}

linkedList::~linkedList() {
    clear();
}

int linkedList::getSize() {
    return stackSize;
}

itemType linkedList::getTop() {
    if (header == nullptr) {
        cout << "리스트가 비어있는데, getTop 실행" << '\n';
        exit(0);
    }
    return top->key;
}

void linkedList::push(itemType key) {
    //리스트가 비어있는 경우
    if (header == nullptr) {
        header = new node;
        header->key = key;
        top = header;
    }
    //리스트에 노드가 하나라도 있는 경우
    else {
        node* insertNode = new node;
        insertNode->key = key;
        insertNode->next = top;
        top = insertNode;
    }
    stackSize++;
}

itemType linkedList::pop() {
    // 노드가 하나만 남아있을 때
    if (header == top) {
        itemType temp = top->key;
        delete top;
        header = nullptr;
        top = nullptr;
        stackSize--;
        return temp;
    }
    //리스트가 비어있을 때
    else if (header == nullptr) {
        cout << "리스트가 비어있는데 pop 실행";
        exit(0);
    }

    //리스트에 노드가 2개 이상 있을 때
    else {
        node* deleteNode;
        itemType temp = top->key;

        deleteNode = top;
        top = top->next;
        delete deleteNode;
        stackSize--;

        return temp;
    }
}

void linkedList::clear() {
    node* deleteNode;
    while (getSize() != 0) {
        deleteNode = top;
        top = top->next;
        delete deleteNode;
        stackSize--;
    }
}

void linkedList::printList() {
    node* temp = top;

    while (temp != nullptr) {
        cout << temp->key << " ";
        temp = temp->next;
    }
}