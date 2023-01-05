# 내 풀이
num_case = int(input())
for _ in range(num_case):
    case = list(map(int, input().split()))
    num_student = case.pop(0)
    avg_student = sum(case) / num_student

    num_over_avg: int = 0
    for i in range(len(case)):
        if case[i] > avg_student:
            num_over_avg += 1

    rate = num_over_avg / num_student * 100
    print(f'{rate:.3f}%')  # f-string

    '''
    # 틀린 풀이 -> 40.000%만 40.0%로 나옴
    print(round(num_over_avg / len(case) * 100, 3), end='')
    print('%')
    '''

    '''
#다른 풀이
n = int(input())

for _ in range(n):
    nums = list(map(int, input().split()))
    avg = sum(nums[1:]) / nums[0]  # 문자열 슬라이싱
    cnt = 0
    for score in nums[1:]:
        if score > avg:
            cnt += 1  # 평균 이상인 학생 수
    rate = cnt / nums[0] * 100
    print(f'{rate:.3f}%')
    '''