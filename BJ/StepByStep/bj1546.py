num = int(input())
score_list = list(map(int, input().split()))
fixed_list = []
max_score = max(score_list)

for i in range(num):  # 점수 수정하기
    fixed_list.append(score_list[i] / max_score * 100)

print(sum(fixed_list) / num)
