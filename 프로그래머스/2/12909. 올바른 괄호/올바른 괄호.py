def solution(s):
    stack = []
    for e in s:
        if e == '(':
            stack.append('(')
        elif len(stack) != 0:
            stack.pop()
        else:
            return False
        
    return True if len(stack) == 0 else False