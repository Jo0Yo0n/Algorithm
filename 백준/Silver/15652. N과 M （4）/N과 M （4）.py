n, m = map(int, input().split())


def solve(start, lst):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(start, n + 1):
        lst.append(i)
        solve(i, lst)
        lst.pop()


solve(1, [])
