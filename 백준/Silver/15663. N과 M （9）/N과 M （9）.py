def solve(k):
    if k == m:
        print(*answer)
        return

    temp = -1
    for i in range(n):
        if visited[i] or temp == num[i]:
            continue

        answer[k] = temp = num[i]
        visited[i] = True
        solve(k + 1)
        visited[i] = False


n, m = map(int, input().split())
num = list(map(int, input().split()))
n = len(num)
num.sort()
answer = [0 for i in range(m)]
visited = [False for i in range(n)]

solve(0)
