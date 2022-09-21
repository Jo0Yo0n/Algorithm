#include <iostream>
#define NAME_SIZE 21

using namespace std;

struct player {
    int price;
    char name[NAME_SIZE];
};

int main() {
    int testcase, playerNum, maxIndex = 0;
    player* playerArray;  //* 한 테스트 케이스에서 사용할 플레이어 구조체 배열
    cin >> testcase;

    for (int i = 0; i < testcase; i++) {
        cin >> playerNum;
        playerArray = new player[playerNum];  //* 테스트 케이스의 선수 수 만큼 동적할당

        for (int j = 0; j < playerNum; j++) {  //* 선수의 가격과 이름을 입력 받고, 해당 테스트 케이스에서 가장 비싼 선수의 인덱스 저장
            cin >> playerArray[j].price >> playerArray[j].name;

            if (playerArray[j].price >= playerArray[maxIndex].price) maxIndex = j;
        }
        cout << playerArray[maxIndex].name << '\n';
        maxIndex = 0;

        delete playerArray;  //* 다음 테스트 케이스를 위해 동적할당 해제
    }
}
