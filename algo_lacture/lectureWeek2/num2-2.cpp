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