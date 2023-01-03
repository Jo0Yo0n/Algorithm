N = int(input())
max_min_list = list(map(int, input().split()))
min_value: int = 1000001
max_value: int = -1000001

for i in range(len(max_min_list)):
    if max_min_list[i] > max_value:  # 최대값 찾기
        max_value = max_min_list[i]

    if max_min_list[i] < min_value:  # 최소값 찾기
        min_value = max_min_list[i]

print(min_value, max_value)