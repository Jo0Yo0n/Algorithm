diff_list = [int(input()) % 42 for _ in range(10)]
"""
# 내 풀이: 새로운 리스트 생성해서 원소가 안들어있으면 추가하는 방식
remain_list = []
for i in range(10):
    if diff_list[i] not in remain_list:
        remain_list.append(diff_list[i])
print(len(remain_list))
"""
diff_list = set(diff_list)  # 집합 자료형으로 변환
print(len(diff_list))
