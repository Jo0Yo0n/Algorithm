def solution(nums):
    max_value = len(nums) // 2
    s = set(nums)
    return len(s) if max_value > len(s) else max_value