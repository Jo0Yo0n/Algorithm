num = int(input())
test_case = []

# 내 풀이
for i in range(num):
    test_case.append(input())

combo: int = 0  # 연속된 'O'를 처리하기 위한 변수
score_list = [0 for _ in range(num)]  # 리스트를 0으로 초기화

for i in range(num):
    for j in range(len(test_case[i])):
        if test_case[i][j] == 'O':
            combo += 1
            score_list[i] += combo
        else:  # X인 경우
            combo = 0
        if j == len(test_case[i]) - 1:  # 문자열의 끝인 경우
            combo = 0

for i in range(num):
    print(score_list[i])

"""
# 다른 풀이
for _ in range(num):
    test_case = list(input())   #입력을 list에 집어 넣는 코드
    combo = 0
    sum_score = 0
    for ox in test_case:
        if ox == 'O':
            combo += 1
            sum_score += combo
        else:
            combo = 0
    print(sum_score)
"""
