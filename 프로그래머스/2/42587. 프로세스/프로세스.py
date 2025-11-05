def solution(priorities, location):
    temp = [False for _ in range(len(priorities))]
    temp[location] = True
    
    p_queue = list(zip(priorities, temp))
    
    d = {}
    for p in priorities:
        d[p] = d.get(p, 0) + 1
    
    ans = 0
    while True:
        flag = True
        
        for i in range(p_queue[0][0] + 1, 10):
            if d.get(i, 0) > 0:
                p_queue.append(p_queue.pop(0))
                flag = False
                break
            
        if flag:
            d[p_queue[0][0]] -= 1
            ans += 1
            t = p_queue.pop(0)
            if t[1]:
                return ans