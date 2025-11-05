def solution(priorities, location):
    q = [(i, p) for (i, p) in enumerate(priorities)]
    ans = 0
    
    while True:
        temp = q.pop(0)
        if any(temp[1] < other for (_, other) in q):
            q.append(temp)
            
        else:
            ans += 1
            if temp[0] == location:
                return ans