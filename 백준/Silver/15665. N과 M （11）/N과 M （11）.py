def solve(k):
    if k == m:
        print(*ans)
        return

    temp = 0
    for i in range(n):
        if temp == nums[i]:
            continue

        temp = nums[i]
        ans.append(nums[i])
        solve(k + 1)
        ans.pop()


n, m = map(int, input().split())
nums = list(map(int, input().split()))
ans = []

nums.sort()
solve(0)
