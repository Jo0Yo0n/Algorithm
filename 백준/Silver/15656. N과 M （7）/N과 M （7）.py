n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()


def solve(lst):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(n):
        lst.append(arr[i])
        solve(lst)
        lst.pop()


solve([])
