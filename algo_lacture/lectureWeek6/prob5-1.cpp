/**
 * @file prob5-1.cpp
 * @author JOOYOON LEE (dlwndbs10@gmail.com)
 * @brief Stack을 이용하여 postfix 수식을 binary parse tree로 표현 후, INORDER traversal
 *  + postfix, prefix는 Stack을 이용해 구현 가능
 * @version 0.1
 * @date 2022-10-06
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
struct node *x, *z;  // x: 새로 할당된 node를 가리키는 포인터, z: 더 이상 이어진 노드가 없다는 것을 표현하기 위한 포인터 (종료조건)
typedef struct node *itemType;

class Stack {
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

void visit(struct node *t) {
    cout << t->info;
}

void traverse(struct node *t) {  // Inorder traverse로 출력을 위한 함수 (Inorder traverse: 중위순회 + Preorder, Postorder)
    if (t != z) {
        cout << '(';
        traverse(t->l);
        visit(t);
        traverse(t->r);
        cout << ')';
    }
}

int main() {
    char c;
    Stack stack(50);
    z = new node;  //빈 노드를 표현
    z->l = z;
    z->r = z;

    while ((c = cin.get()) != '\n') {  // Tree 구현
        while (c == ' ') cin.get(c);
        x = new node;
        x->info = c;
        x->l = z;
        x->r = z;

        if (c == '+' || c == '*') {  // postfix 수식 (prefix: 연속된 숫자 2개가 입력되면 Stack에서 연산자를 꺼낸다.)
            if (!stack.empty()) {
                x->r = stack.pop();
            }
            if (!stack.empty()) {
                x->l = stack.pop();
            }
        }
        stack.push(x);
    }
    traverse(x);  //순회하며 탐색
}
