def solution(prices):
    answer = [0] * len(prices)
    
    stack = []
    for i, p in enumerate(prices):
        while stack and stack[-1][1] > p:
            answer[stack[-1][0]] = i - stack[-1][0]
            stack.pop()
        
        stack.append((i, p))
    
    duration = len(prices) - 1
    
    while stack:
        answer[stack[-1][0]] = duration - stack[-1][0]
        stack.pop()
    
    return answer