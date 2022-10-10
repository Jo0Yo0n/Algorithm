/**
 * @file prob5-3.cpp
 * @author JOOYOON LEE (dlwndbs10@gmail.com)
 * @brief 5-1, 5-2에서 구현한 Stack과 Queue를 연결리스트를 이용하여 구현
 * @version 0.1
 * @date 2022-10-10
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

typedef struct node {
    char info;
    struct node *l, *r;
    struct node *next;  // Linked List로 Stack 구현을 위한 next 포인터 변수 선언
} itemType;
struct node *x, *z;

class Stack {
   private:
    itemType *stackHeader;

   public:
    Stack() {  // stackHeader가 dummy node를 가리킴
        stackHeader = new itemType;
        stackHeader->info = -1;
        stackHeader->l = z;
        stackHeader->r = z;
        stackHeader->next = nullptr;
    }
    ~Stack() {
        itemType *ptr = stackHeader;
        itemType *temp;
        while (ptr != nullptr) {
            temp = ptr->next;
            delete ptr;
            ptr = temp;
        }
    }
    void push(itemType *v);
    itemType *pop();
    int empty();
};

class Queue {
   private:
    itemType *head, *tail;
    int count;

   public:
    Queue() {
        head = tail = nullptr;
        count = 0;
    }
    void put(itemType *v);
    itemType *get();
    int empty();
};
Queue queue;

void visit(itemType *t);
void inorderTraverse(itemType *t);
void levelOrderTraverse(itemType *t);

int main() {
    char c;
    Stack stack;
    z = new node;
    z->l = z;
    z->r = z;
    z->next = nullptr;

    while ((c = cin.get()) != '\n') {
        while (c == ' ') cin.get(c);
        x = new node;
        x->info = c;
        x->l = z;
        x->r = z;

        if (c == '+' || c == '*') {
            if (!stack.empty()) {
                x->r = stack.pop();
            }
            if (!stack.empty()) {
                x->l = stack.pop();
            }
        }
        stack.push(x);
    }
    levelOrderTraverse(x);
    cout << '\n';
}

void Stack::push(itemType *v) {
    v->next = stackHeader->next;
    stackHeader->next = v;
}

itemType *Stack::pop() {
    itemType *temp;

    temp = stackHeader->next;
    stackHeader->next = stackHeader->next->next;

    return temp;
}

int Stack::empty() {
    if (stackHeader->next == nullptr)
        return true;
    else
        return false;
}

void Queue::put(itemType *v) {
    if (empty()) {
        head = v;
    } else {
        tail->next = v;
    }
    tail = v;
    count++;
}

itemType *Queue::get() {
    itemType *temp = head;
    head = temp->next;
    count--;
    return temp;
}

int Queue::empty() {
    return !count;
}

void visit(itemType *t) {
    cout << t->info << ' ';
}

void inorderTraverse(itemType *t) {
    if (t != z) {
        cout << "(";
        inorderTraverse(t->l);
        visit(t);
        inorderTraverse(t->r);
        cout << ")";
    }
}

void levelOrderTraverse(itemType *t) {
    queue.put(t);
    while (!queue.empty()) {
        t = queue.get();
        visit(t);
        if (t->l != z) queue.put(t->l);
        if (t->r != z) queue.put(t->r);
    }
}