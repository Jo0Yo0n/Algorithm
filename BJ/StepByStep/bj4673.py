def kaprekar_func(x: int) -> int:  # x와 x의 각 자리수를 더하는 함수
    each_of_x = []
    temp: int = x
    while temp != 0:
        each_of_x.append(temp % 10)
        temp = temp // 10
    return x + sum(each_of_x)


ans_list = [i for i in range(1, 10000 + 1)]  # 1부터 10000까지의 수를 리스트에 저장

for i in range(1, 10000 + 1):   # 1부터 10000까지 함수에 대입 후, 리턴값이 list에 존재하면 그 수를 삭제
    kaprekar_num = kaprekar_func(i)
    if kaprekar_num in ans_list:
        ans_list.remove(kaprekar_num)

for i in range(len(ans_list)):  # 남은 수 출력
    print(ans_list[i])
