#include <iostream>

using namespace std;

struct node {
    int key;
    struct node* next;
};

int main() {
    int i, N, M, count;  //* N: 생성되는 node의 개수 M: 삭제되는 node의 간격
    struct node *t, *x;
    cin >> N >> M;
    t = new node;
    t->key = 1;
    x = t;

    for (i = 2; i <= N; i++) {  //* 연결 리스트 생성
        t->next = new node;
        t = t->next;
        t->key = i;
    }
    t->next = x;  //* 원형 연결 리스트

    while (t != t->next) {                    //* node가 1개 남을 때까지 반복
        for (i = 1; i < M; i++) t = t->next;  //* M 만큼 다음 노드로 이동
        cout << t->next->key << " ";
        x = t->next;        //* node 삭제
        t->next = x->next;  //* t->next->next
        delete x;

        count++;
    }

    cout << t->key << '\n';       //* 1개 남은 node의 key 출력
    cout << "count = " << count;  //* while loop가 실행된 횟수 출력
    cout << '\n';
}