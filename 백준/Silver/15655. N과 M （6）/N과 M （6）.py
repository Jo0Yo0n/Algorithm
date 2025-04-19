n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()


def solve(start, lst):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(start, n):
        lst.append(arr[i])
        solve(i + 1, lst)
        lst.pop()


solve(0, [])
