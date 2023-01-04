student = [i for i in range(1,31)]

for _ in range(28):
    applied = int(input())  # 과제 제출한 학생 입력 받음
    student.remove(applied) # 학생 목록에서 과제 제출한 학생 제외 -> 남은 학생은 과제 안 낸 학생

print(min(student))
print(max(student))

"""
# 나의 풀이
attendance = [int(input()) for _ in range(28)]
attendance.sort()  # 오름차순 정렬

empty1: int = -1
empty2: int = -1

check: int = 1
for i in range(28):
    if attendance[i] != check:
        if empty1 == -1:
            empty1 = check
            check = check + 1
        else:
            empty2 = check
            check = check + 1

    # for문 마지막까지 도달했을 때 처리
    if i == 27 and empty1 != -1 and empty2 == -1:
        empty2 = check + 1
    elif i == 27 and empty1 == empty2 == -1:
        empty1 = 29
        empty2 = 30
    check = check + 1

print(empty1)
print(empty2)
"""