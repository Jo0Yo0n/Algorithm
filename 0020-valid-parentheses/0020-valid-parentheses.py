class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                
                top = stack.pop()
                if top == '(' and c != ')':
                    return False
                elif top == '{' and c != '}':
                    return False
                elif top == '[' and c != ']':
                    return False
        
        return len(stack) == 0