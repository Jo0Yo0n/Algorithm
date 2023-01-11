# 일의 자리 수와 십의 자리 수는 모두 각 자리 수가 등차수열
# 백의 자리 수 부터 각 자리 수가 등차 수열인지 확인해야 함
num = int(input())

n: int = num
list_n = []

while n != 0:
    list_n.append(n % 10)
    n //= 10

arithmetic_seq: int = 0
if len(list_n) == 1 or len(list_n) == 2:  # 일의 자리 수 or 십의 자리 수
    arithmetic_seq = num  # 일의 자리 수와 백의 자리 수는 모두 각 자리 수가 등차 수열

else:  # 백의 자리 수, 천의 자리 수 (= 1000)
    for i in range(100, num + 1):
        if i == 1000:   # i == 1000이면 break
            break
        list_temp = []  # 각 자리 수를 분리
        while i != 0:
            list_temp.append(i % 10)
            i //= 10

        if list_temp[2] < list_temp[1] < list_temp[0]:  # 오름차순
            if list_temp[0] - list_temp[1] == list_temp[1] - list_temp[2]:
                arithmetic_seq += 1
        elif list_temp[2] > list_temp[1] > list_temp[0]:  # 내림차순
            if list_temp[1] - list_temp[0] == list_temp[2] - list_temp[1]:
                arithmetic_seq += 1
        elif list_temp[2] == list_temp[1] == list_temp[0]:  # 각 자리 수가 같음
            arithmetic_seq += 1

    arithmetic_seq += 99  # 일의 자리 수, 십의 자리 수는 각 자리 수가 등차수열

print(arithmetic_seq)
