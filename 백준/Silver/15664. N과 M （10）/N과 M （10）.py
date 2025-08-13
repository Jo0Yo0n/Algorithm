def solve(k, idx):
    if k == m:
        print(*ans)

    temp = 0
    for i in range(idx, n):
        if temp == num[i]:
            continue

        temp = num[i]
        ans.append(num[i])
        solve(k + 1, i + 1)
        ans.pop()


n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
ans = []
solve(0, 0)
