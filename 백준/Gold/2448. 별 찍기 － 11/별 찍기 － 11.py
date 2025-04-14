n = int(input())

arr = ["" for _ in range(n)]
for i in range(n):
    arr[i] += " " * (n - i - 1)


def solve(n, k):
    if n == 3:
        arr[k] += "*"
        arr[k + 1] += "* *"
        arr[k + 2] += "*****"
        return

    unit = n // 2

    for i in range(4):
        if i == 2:
            t = unit
            for j in range(n - 1, 0, -2):
                arr[k + t] += " " * j
                t += 1
        else:
            if i == 0:
                solve(unit, k)
            else:
                solve(unit, k + unit)


solve(n, 0)

for i in range(n):
    arr[i] += " " * (n - i - 1)

for i in range(n):
    print(arr[i])
