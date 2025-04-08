n = int(input())
list = [list(map(int, input().split())) for _ in range(n)]
ans = [0, 0, 0]


def check(start, end, size):
    for i in range(start, start + size):
        for j in range(end, end + size):
            if list[start][end] != list[i][j]:
                return False
    return True


def solve(start, end, size):
    if check(start, end, size):
        ans[list[start][end]] += 1
        return

    n = size // 3
    for i in range(3):
        for j in range(3):
            solve(start + i * n, end + j * n, n)


solve(0, 0, n)
print(ans[-1])
print(ans[0])
print(ans[1])
