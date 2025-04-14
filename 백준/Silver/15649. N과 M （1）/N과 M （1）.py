n, m = map(int, input().split())

visited = [False for _ in range(n + 1)]

arr = []


def solve(cnt):
    if cnt == m:
        print(*arr)
        return

    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True
            arr.append(i)
            solve(cnt + 1)
            visited[i] = False
            arr.pop()


solve(0)
