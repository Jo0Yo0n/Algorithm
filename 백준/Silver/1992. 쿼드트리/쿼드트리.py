n = int(input())
arr = [list(map(int, list(input().strip()))) for _ in range(n)]


def check(x, y, size):
    for i in range(x, x + size):
        for j in range(y, y + size):
            if arr[x][y] != arr[i][j]:
                return False
    return True


def solve(x, y, size):
    if check(x, y, size):
        print(arr[x][y], end="")
        return

    size //= 2
    print("(", end="")
    solve(x, y, size)
    solve(x, y + size, size)
    solve(x + size, y, size)
    solve(x + size, y + size, size)
    print(")", end="")

    return


solve(0, 0, n)
