diff_list = [int(input()) % 42 for _ in range(10)]
remain_list = []
for i in range(10):
    if diff_list[i] not in remain_list:
        remain_list.append(diff_list[i])
print(len(remain_list))