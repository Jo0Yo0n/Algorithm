def solution(prices):
    answer = [0] * len(prices)
    stack = []
    
    for idx, price in enumerate(prices):
        while stack and (stack[-1][1] > price or idx == len(prices) - 1):
            i, p = stack.pop()
            answer[i] = idx - i
        
        stack.append((idx, price))
                         
    return answer