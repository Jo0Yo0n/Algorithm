n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
visited = [False for _ in range(n)]


def solve(lst):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(n):
        if visited[i]:
            continue

        visited[i] = True
        lst.append(arr[i])
        solve(lst)
        visited[i] = False
        lst.pop()


solve([])
