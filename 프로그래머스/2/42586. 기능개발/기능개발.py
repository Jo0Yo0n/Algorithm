from collections import deque

def solution(progresses, speeds):
    pgdq = deque(progresses)
    spdq = deque(speeds)
    ans = []
    
    while pgdq:
        for i in range(len(pgdq)):
            pgdq[i] += spdq[i]
        
        c = 0
        while pgdq and pgdq[0] >= 100:
            pgdq.popleft()
            spdq.popleft()
            c += 1
        if c:
            ans.append(c)  
        
    return ans