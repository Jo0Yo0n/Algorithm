n, m = map(int, input().split())

lst = [i for i in range(1, n + 1)]


def solve(n, m, seq):
    if len(seq) == m:
        print(" ".join(map(str, seq)))
        return

    global lst
    lst_set = set(lst)
    before_set = set(seq)
    sub = list(lst_set - before_set)

    for i in range(len(sub)):
        copy = seq[:]
        copy.append(sub[i])
        solve(n, m, copy)


solve(n, m, [])
