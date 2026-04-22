def solution(numbers, target):
    answer = 0
    def dfs(idx, result):
        nonlocal answer
        
        if idx == len(numbers):
            if result == target:
                answer += 1
            return
        
        dfs(idx + 1, result + numbers[idx])
        dfs(idx + 1, result - numbers[idx])
    
    dfs(0, 0)
    return answer