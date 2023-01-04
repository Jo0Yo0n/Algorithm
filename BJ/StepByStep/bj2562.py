max_list = []
"""
# for문 이용
for _ in range(9):
    max_list.append(int(input()))
"""

max_list = [int(input()) for _ in range(9)]  # list comprehension

print(max(max_list))
print(max_list.index(max(max_list)) + 1)
