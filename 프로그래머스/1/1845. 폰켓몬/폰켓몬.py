def solution(nums):
    nums.sort()
    lst = []
    
    for i in range(len(nums)):
        if len(lst) == (len(nums) // 2):
            return len(lst)
        
        if i > 0 and (nums[i] == nums[i - 1]):
            continue
        
        lst.append(nums[i])
    
    return len(lst)