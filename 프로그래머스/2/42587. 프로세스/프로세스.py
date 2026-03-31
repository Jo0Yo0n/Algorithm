from collections import deque

def solution(priorities, location):
    dq = deque(zip(priorities, range(len(priorities))))
    count = 1
    
    while dq:
        p, l = dq[0]
        
        for i in range(1, len(dq)):
            if dq[i][0] > p:
                dq.append(dq.popleft())
                break
        
        if l == dq[0][1]:
            if l == location:
                return count
            else:
                dq.popleft()
                count += 1