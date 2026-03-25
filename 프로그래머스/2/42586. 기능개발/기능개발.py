from collections import deque
import math

def solution(progresses, speeds):
    p_dq = deque(progresses)
    s_dq = deque(speeds)
    answer = []
    
    count = 0
    day = 0
    for p, s in zip(p_dq, s_dq):
        if day == 0:
            day = math.ceil((100 - p) / s)
            count += 1
        elif p + (s * day) >= 100:
            count += 1
        else:
            answer.append(count)
            count = 1
            day = math.ceil((100 - p) / s)
            
    if count > 0:
        answer.append(count)
    
    return answer