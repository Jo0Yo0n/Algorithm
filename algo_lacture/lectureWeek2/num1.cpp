#include <iostream>

using namespace std;

class InputNum {
   public:
    InputNum() {  //* 생성자. 사용자에게 숫자 하나를 입력받는다.
        cout << "Enter number ";
        cin >> _num;
    }

    //* 함수 명 뒤의 const의 역할: 이 함수 안에서는 어떤 변수도 바꾸지 않는다.(mutable은 예외)
    //* 이러한 함수를 사용하는 이유: const Object에서 이러한 함수를 부를 수 있음.
    int GetValue() const { return _num; }  //* getter. 멤버변수인 _num을 반환

    //* 새로운 InputNum 객체를 생성한 뒤, 생성자를 이용해 사용자에게 숫자 하나를 입력 받는다.
    void SubtractInput() {
        InputNum aNum;
        _num = _num - aNum.GetValue();
    }

   private:
    int _num;  //* 멤버변수
};

int main() {
    InputNum num;
    cout << "The value is " << num.GetValue() << "\n";
    num.SubtractInput();
    cout << "Now the value is " << num.GetValue() << "\n";
}