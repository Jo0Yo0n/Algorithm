n, m = map(int, input().split())


def solve(lst):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(1, n + 1):
        lst.append(i)
        solve(lst)
        lst.pop()


solve([])
