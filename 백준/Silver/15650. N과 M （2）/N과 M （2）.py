n, m = map(int, input().split())


def solve(length, start, lst):
    if length == m:
        print(*lst)
        return

    for i in range(start, n + 1):
        lst.append(i)
        solve(length + 1, i + 1, lst)
        lst.remove(i)


solve(0, 1, [])
