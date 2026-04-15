ALPHA = "AEIOU"
count = 0

def dfs(current, target):
    global ALPHA
    global count
    
    if current == target:
        return count
    if len(current) == 5:
        return 0
    
    for a in ALPHA:
        count += 1
        answer = dfs(current + a, target)
        if answer:
            return answer

def solution(word):
    
    return dfs("", word)