/**
 * @file num2-2.cpp
 * @author JooYoon Lee (dlwndbs10@gmail.com)
 * @brief 포인터를 사용하여 데이터구조 스택을 구현하고, 다른 연산 (-,/)도 포함된
 * 다음의 data를 처리하는 알고리즘으로 수정하여 실습하시오.
 * 테스트 데이터: 20 30 * 45 3 / + 10 * 9 -
 * @version 0.1
 * @date 2022-09-22
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>
#define itemType int

using namespace std;

class Stack2 {
   public:
    Stack2();
    ~Stack2();
    void push(itemType v);
    itemType pop();
    int empty();

   private:
    struct node {
        itemType key;
        struct node *next;
    };
    struct node *head, *z;
};

Stack2::Stack2() {
    node *dummy = new node;
    dummy->key = -1;
    dummy->next = NULL;
    head = dummy;
}

Stack2::~Stack2() {  //연결리스트의 모든 노드 삭제
    z = head->next;

    while (z != NULL) {
        head->next = z->next;
        delete z;

        z = head->next;
    }
    delete head;  // dummy node까지 삭제
}

void Stack2::push(itemType v) {
    node *newNode = new node;
    newNode->key = v;

    newNode->next = head->next;
    head->next = newNode;
}

itemType Stack2::pop() {
    int returnValue;

    z = head->next;
    returnValue = z->key;
    head->next = z->next;
    delete z;

    return returnValue;
}

int Stack2::empty() {
    if (head->next == NULL)
        return true;
    else
        return false;
}

int main() {
    char c;
    Stack2 acc;
    int x;

    while ((c = cin.get()) != '\n') {
        x = 0;
        while (c == ' ') cin.get(c);
        if (c == '+') x = acc.pop() + acc.pop();
        if (c == '*') x = acc.pop() * acc.pop();
        if (c == '-') x = acc.pop() - acc.pop();
        if (c == '/') x = acc.pop() / acc.pop();
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            cin.get(c);
        }
        acc.push(x);
    }
    cout << acc.pop() << '\n';
}