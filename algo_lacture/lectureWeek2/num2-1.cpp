/**
 * @file num2-1.cpp
 * @author JooYoon Lee (dlwndbs10@gmail.com)
 * @brief 스택을 이용하여 주여진 postfix 표기의 식을 연산하는 알고리즘을 완성하고, 실습하시오.
 * 테스트 데이터: 20 30 * 45 3 * + 10 9 +
 * @version 0.1
 * @date 2022-09-22
 *
 * @copyright Copyright (c) 2022
 *
 */

#include <iostream>
#define itemType int

using namespace std;

class Stack1 {
   private:
    itemType* stack;
    int p;

   public:
    Stack1(int max = 100) {
        stack = new itemType[max];
        p = 0;
    }
    ~Stack1() {
        delete stack;
    }
    inline void push(itemType v) {
        stack[p++] = v;
    }
    inline itemType pop() {
        return stack[--p];
    }
    inline int empty() {  //* 배열이 비어있으면 true, 아니면 false
        return !p;
    }
};

int main() {
    char c;
    Stack1 acc(50);
    int x;

    while ((c = cin.get()) != '\n') {
        x = 0;
        while (c == ' ') cin.get(c);
        if (c == '+') x = acc.pop() + acc.pop();
        if (c == '*') x = acc.pop() * acc.pop();
        while (c >= '0' && c <= '9') {
            x = 10 * x + (c - '0');
            cin.get(c);
        }
        acc.push(x);
    }
    cout << acc.pop() << '\n';
}

//* postfix: 20 30 * 45 3 * + 10 * 9 +
//* = (((20 * 30) + (45 * 3)) * 10) + 9