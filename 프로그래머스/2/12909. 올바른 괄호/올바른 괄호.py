def solution(s):
    stack = []
    for e in s:
        if e == '(':
            stack.append('(')
        else:
            if not stack:
                return False
            else:
                stack.pop()
    
    return len(stack) == 0