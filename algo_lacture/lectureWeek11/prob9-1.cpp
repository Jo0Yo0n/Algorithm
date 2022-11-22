#include <ctime>
#include <iostream>
#include <random>
#define Nmax 20

struct point {
    int x, y;
    char c;
};

struct line {
    struct point p1, p2;
};

struct point polygon[Nmax];

struct poly {
    char p;
    float angleValue;
};

struct point A, B, C, D, E, F, G, H;
float ComputeAngle(struct point p1, struct point p2);
void insertionSort(struct poly list[], int n);

int main() {
    struct poly poly[7];
    // A~H 변수 초기화
    A.x = 3;
    A.y = 4;
    A.c = 'A';
    B.x = 1;
    B.y = 2;
    B.c = 'B';
    C.x = 2;
    C.y = 5;
    C.c = 'C';
    D.x = 2;
    D.y = 6;
    D.c = 'D';
    E.x = 9;
    E.y = 3;
    E.c = 'E';
    F.x = 5;
    F.y = 3;
    F.c = 'F';
    G.x = 6;
    G.y = 4;
    G.c = 'G';
    H.x = 8;
    H.y = 4;
    H.c = 'H';

    // y값이 가장 작은 점 B를 기준점으로 삼고 진행
    poly[0].p = 'A';
    poly[0].angleValue = ComputeAngle(B, A);
    poly[1].p = 'C';
    poly[1].angleValue = ComputeAngle(B, C);
    poly[2].p = 'D';
    poly[2].angleValue = ComputeAngle(B, D);
    poly[3].p = 'E';
    poly[3].angleValue = ComputeAngle(B, E);
    poly[4].p = 'F';
    poly[4].angleValue = ComputeAngle(B, F);
    poly[5].p = 'G';
    poly[5].angleValue = ComputeAngle(B, G);
    poly[6].p = 'H';
    poly[6].angleValue = ComputeAngle(B, H);

    insertionSort(poly, 7);
    for (int i = 0; i < 7; i++) {
        std::cout << poly[i].p << ' ';
    }
    std::cout << '\n';
}

float ComputeAngle(struct point p1, struct point p2) {
    int dx, dy, ax, ay;
    float angle;

    dx = p2.x - p1.x;
    ax = abs(dx);

    dy = p2.y - p1.y;
    ay = abs(dy);

    if ((dx >= 0) && (dy == 0))
        angle = 0;  // x축에 평행한 선에 위치
    else {
        angle = abs(dy) / (abs(dx) + abs(dy));  // 1사분면
        if ((dx < 0) && (dy >= 0))
            angle = 2 - angle;           // 2사분면
        else if ((dx <= 0) && (dy < 0))  // 3사분면
            angle = 2 + angle;
        else if ((dx > 0) && (dy < 0))  // 4사분면
            angle = 4 - angle;
    }
    return angle * 90.0;
}

void insertionSort(struct poly list[], int n) {
    int i, j, key;

    for (i = 1; i < n; i++) {
        key = list[i].angleValue;

        for (j = i - 1; i >= 0 && list[j].angleValue > key; j--) {
            list[j + 1] = list[j];
        }
        list[j + 1].angleValue = key;
    }
}
