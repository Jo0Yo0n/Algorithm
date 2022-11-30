#include <cstdlib>
#include <ctime>
#include <iostream>
#define Nmax 20

struct point {
    int x, y;
    char c;
    float angle;
};
struct line {
    struct point p1, p2;
};

struct point polygon[Nmax + 1];
int GrahamScan(struct point P[], int n);
float ComputeAngle(struct point p1, struct point p2, int calculation);
void Swap(struct point* a, struct point* b);
int Min(struct point a[], int n);
void FindSimplePolygon(struct point P[], int n);
int Direction(struct point A, struct point B, struct point C);
void shellSort(struct point* a, int n);
void print(struct point* a, int n);

int Calculation;   // 수평각 계산 회수
int Compare;       //각 비교 회수
int InnerDot;      // Convex Hull 내부 점의 개수
int WrappedCount;  // Convex Hull 꼭지점 수

int main() {
    srand(time(NULL));
    int n = 8;

    // 주어진 자료로 이루어진 point 구조체 배열 poly
    struct point poly[] = {
        {-1, -1, ' ', -1},  // Index 1부터 시작
        {3, 4, 'A', 0},
        {1, 2, 'B', 0},
        {2, 5, 'C', 0},
        {2, 6, 'D', 0},
        {9, 3, 'E', 0},
        {5, 3, 'F', 0},
        {6, 4, 'G', 0},
        {8, 4, 'H', 0}};

    // N (>20) 개의 점을 random() 함수로 발생시켜 저장하는 point 구조체 배열 polygon
    for (int i = 1; i <= Nmax; i++) {
        polygon[i].x = rand() % 100;
        polygon[i].y = rand() % 100;
        polygon[i].c = i + 1 + 'A';
    }
    polygon[0].x = -1;  // Index 1부터 시작
    polygon[0].y = -1;

    std::cout << "단순 다각형" << '\n';  //단순 다각형 출력
    FindSimplePolygon(poly, n);
    print(poly, n);
    std::cout << '\n';

    WrappedCount = GrahamScan(poly, n);  // Convex Hull 출력
    std::cout << "주어진 자료의 Convex Hull" << '\n';
    print(poly, WrappedCount - 1);
    std::cout << poly[n].c << "(" << poly[n].x << "," << poly[n].y << ")" << '\n';
    InnerDot = n - WrappedCount;

    //비교횟수 출력
    std::cout << "주어진 자료의 수평각 계산 회수: " << Calculation << '\n';
    std::cout << "주어진 자료의 각 비교 회수: " << Compare << '\n';
    std::cout << "주어진 자료의 Convex Hull 내부 점의 수: " << InnerDot << '\n';
    std::cout << '\n'
              << '\n';

    // 변수 초기화
    Calculation = 0;
    Compare = 0;
    InnerDot = 0;
    WrappedCount = 0;

    std::cout << "단순 다각형" << '\n';  //단순 다각형 출력
    FindSimplePolygon(polygon, Nmax);
    print(polygon, Nmax);
    std::cout << '\n';

    WrappedCount = GrahamScan(polygon, Nmax);  // Convex Hull 출력
    std::cout << "랜덤 자료의 Convex Hull" << '\n';
    print(polygon, WrappedCount - 1);
    std::cout << polygon[Nmax].c << "(" << polygon[Nmax].x << ", " << polygon[Nmax].y << ")" << '\n';
    InnerDot = Nmax - WrappedCount;

    //비교횟수 출력
    std::cout << "랜덤 자료의 수평각 계산 회수: " << Calculation << '\n';
    std::cout << "랜덤 자료의 각 비교 회수: " << Compare << '\n';
    std::cout << "랜덤 자료의 Convex Hull 내부 점의 수: " << InnerDot << '\n';
    std::cout << '\n'
              << '\n';
}

int GrahamScan(struct point P[], int n) {
    int i, FirstPoint, NextPoint;
    FirstPoint = 1;
    for (i = 2; i <= n; i++) {  // y좌표가 최소인 점 찾기
        if (P[i].y < P[FirstPoint].y) FirstPoint = i;
    }
    for (i = 1; i < n; i++) {  // x, y좌표가 최소인 점 찾기
        if (P[i].y == P[FirstPoint].y && P[i].x > P[FirstPoint].x) FirstPoint = i;
    }
    Swap(&P[FirstPoint], &P[1]);
    FindSimplePolygon(P, n);  // 단순 다각형 구하기
    P[0] = P[n];
    NextPoint = 3;
    for (i = 4; i <= n; i++) {  // Convex Hull의 꼭짓점이 될 수 없는 점 제거
        while (Direction(P[NextPoint], P[NextPoint - 1], P[i]) <= 0) NextPoint--;
        NextPoint++;
        Swap(&P[NextPoint], &P[i]);
    }
    return NextPoint;  // Convex Hull의 꼭지점의 수를 반환
}

float ComputeAngle(struct point p1, struct point p2) {
    int dx, dy, ax, ay;
    float angle;
    Calculation++;

    dx = p2.x - p1.x;
    ax = abs(dx);

    dy = p2.y - p1.y;
    ay = abs(dy);

    angle = (ax + ay == 0) ? 0 : (float)dy / (ax + ay);  // 1 사분면
    if (dx < 0)
        angle = 2 - angle;  // 2,3 사분면
    else if (dy < 0)
        angle = 4 + angle;  // 3,4 사분면
    return angle * 90.0;
}

void Swap(struct point* a, struct point* b) {
    struct point temp;
    temp.c = a->c;
    temp.x = a->x;
    temp.y = a->y;

    a->c = b->c;
    a->x = b->x;
    a->y = b->y;

    b->c = temp.c;
    b->x = temp.x;
    b->y = temp.y;
}

// point 중 y값이 가장 작은 point를 찾아서 해당 point의 index를 반환
int Min(struct point a[], int n) {
    struct point min;
    min = a[1];
    int minIndex = 1;
    for (int i = 2; i <= n; i++) {
        if (min.y > a[i].y) {
            min = a[i];
            minIndex = i;
        }
    }
    return minIndex;
}

void FindSimplePolygon(struct point P[], int n) {
    Swap(&P[1], &P[Min(P, n)]);
    for (int i = 2; i <= n; i++) {
        P[i].angle = ComputeAngle(P[1], P[i]);
    }
    shellSort(P, n);
}

// 세 점의 상대 위치를 결정
int Direction(struct point A, struct point B, struct point C) {
    int dxAB, dxAC, dyAB, dyAC, d;
    dxAB = B.x - A.x;
    dyAB = B.y - A.y;
    dxAC = C.x - A.x;
    dyAC = C.y - A.y;

    if (dxAB * dyAC < dyAB * dxAC)
        d = 1;                           // 시계 방향
    else if (dxAB * dyAC > dyAB * dxAC)  // 반시계 방향
        d = -1;
    else if (dxAB * dyAC == dyAB * dxAC) {  // 일직선
        if (dxAB == 0 && dyAB == 0)
            d = 0;  // A, B가 동일
        else if ((dxAB * dxAC < 0) || (dyAB * dyAC < 0))
            d = -1;  // A가 가운데에 위치
        else if ((dxAB * dxAB + dyAB * dyAB) >= (dxAC * dxAC + dyAC * dyAC))
            d = 0;  // C가 가운데에 위치
        else
            d = 1;
    }
    return d;
}

void shellSort(struct point* a, int n) {
    int i, j, h;
    struct point p;
    h = 1;
    do {
        h = 3 * h + 1;
    } while (h < n);
    do {
        h = h / 3;
        for (i = h; i <= n; i++) {
            p.angle = a[i].angle;
            p.c = a[i].c;
            p.x = a[i].x;
            p.y = a[i].y;
            j = i;

            while (a[j - h].angle > p.angle) {
                Compare++;
                a[j].x = a[j - h].x;
                a[j].y = a[j - h].y;
                a[j].c = a[j - h].c;
                a[j].angle = a[j - h].angle;
                j -= h;
                if (j < h - 1) break;
            }
            Compare++;
            a[j].angle = p.angle;
            a[j].c = p.c;
            a[j].x = p.x;
            a[j].y = p.y;
        }
    } while (h > 1);
}

void print(struct point* a, int n) {
    for (int i = 1; i <= n; i++) {
        std::cout << a[i].c << "(" << a[i].x << "," << a[i].y << ")" << '\n';
    }
}