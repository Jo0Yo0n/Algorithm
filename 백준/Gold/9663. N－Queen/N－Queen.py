n = int(input())
ans = 0
visited = [[0 for _ in range(n)] for _ in range(n)]


def check(x, y, t):
    visited[x][y] += t

    for i in range(n):
        if i == y:
            continue
        visited[x][i] += t

    for i in range(n):
        if i == x:
            continue
        visited[i][y] += t

    for i in range(1, n):
        if x - i >= 0 and y - i >= 0:
            visited[x - i][y - i] += t

    for i in range(1, n):
        if x - i >= 0 and y + i < n:
            visited[x - i][y + i] += t

    for i in range(1, n):
        if x + i < n and y + i < n:
            visited[x + i][y + i] += t

    for i in range(1, n):
        if x + i < n and y - i >= 0:
            visited[x + i][y - i] += t


def solve(row):
    if row == n:
        global ans
        ans += 1
        return

    for col in range(n):
        if visited[row][col]:
            continue

        check(row, col, 1)
        solve(row + 1)
        check(row, col, -1)


solve(0)
print(ans)
