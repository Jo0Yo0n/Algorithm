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
                     
# 최대 개수(답)는 반드시 N/2 개
# 리스트를 정렬한 뒤에 백트래킹으로 하나씩 담아간다면? (중복되는건 제외하면서)