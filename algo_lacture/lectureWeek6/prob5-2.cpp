/**
 * @file prob5-2.cpp
 * @author JOOYOON LEE (dlwndbs10@gmail.com)
 * @brief Stack을 이용하여 prefix 수식을 Tree로 표현 -> 해당 Tree를 Queue에 삽입하여 Level Order Traverse로 출력
 * @version 0.1
 * @date 2022-10-07
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

using namespace std;

struct node {
    char info;
    struct node *l, *r;
};
typedef struct node *itemType;  // Stack, Queue를 배열로 구현하기 때문에 double pointer로 선언
struct node *x, *z;

void visit(struct node *t);
void levelOrderTraverse(struct node *t);

class Stack {  // postfix 수식 입력을 받아 tree로 만들기 위해 node를 저장하는 Stack
   private:
    itemType *stack;
    int p;

   public:
    Stack(int max = 100) {
        stack = new itemType[max];  //포인터 배열 (node pointer의 배열)
        p = 0;
    }
    ~Stack() {
        delete stack;
    }
    inline void push(itemType v) {
        stack[p++] = v;
    }
    inline itemType pop() {
        return stack[--p];
    }
    inline int empty() {
        return !p;
    }
};

class Queue {  // Lever Order Traverse를 구현하기 위한 Queue
   private:
    itemType *queue;
    int head, tail, size;

   public:
    Queue(int max = 100) {
        queue = new itemType[max];
        head = tail = 0;
        size = max;
    }
    ~Queue() {
        delete queue;
    }
    void put(itemType v);
    itemType get();
    int empty();
};
Queue queue;  //전역변수로 queue 선언

int main() {
    char c;
    Stack stack(50);
    z = new node;
    z->l = z;
    z->r = z;

    while ((c = cin.get()) != '\n') {  // Stack을 이용하여 Tree 저장
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

void Queue::put(itemType v) {
    queue[tail++] = v;
    if (tail > size) tail = 0;
}

itemType Queue::get() {
    itemType t = queue[head++];
    if (head > size) head = 0;
    return t;
}

int Queue::empty() {
    return head == tail;
}

void visit(struct node *t) {
    cout << t->info << " ";
}

void levelOrderTraverse(struct node *t) {  // Stack을 이용해 구현한 Tree를 Queue에 삽입 -> Level Order Traverse
    queue.put(t);
    while (!queue.empty()) {
        t = queue.get();
        visit(t);
        if (t->l != z) queue.put(t->l);
        if (t->r != z) queue.put(t->r);
    }
}