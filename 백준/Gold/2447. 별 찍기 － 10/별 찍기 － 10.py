n = int(input())

ans = ["" for _ in range(n)]


def solve(n, k):
    if n == 3:
        ans[k] += "***"
        ans[k + 1] += "* *"
        ans[k + 2] += "***"
        return

    unit = n // 3
    for i in range(9):
        if i == 4:
            for j in range(k + unit, k + 2 * unit):
                ans[j] += " " * unit
            continue

        t = k + (i // 3) * unit
        solve(n // 3, t)


solve(n, 0)

for i in range(n):
    print(ans[i])
