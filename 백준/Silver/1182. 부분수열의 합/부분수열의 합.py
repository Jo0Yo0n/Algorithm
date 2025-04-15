n, s = map(int, input().split())
arr = list(map(int, input().split()))
visited = [False for _ in range(n)]
ans = 0


def solve(k):
    if k == n:
        return

    for i in range(k, n):
        visited[i] = True

        sum = 0
        for j in range(n):
            if visited[j]:
                sum += arr[j]

        if sum == s:
            global ans
            ans += 1

        solve(i + 1)
        visited[i] = False


solve(0)
print(ans)
