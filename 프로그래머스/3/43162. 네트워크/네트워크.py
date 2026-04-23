from collections import deque

def solution(n, computers):
    answer = 0
    queue = deque()
    
    def bfs(i):
        nonlocal answer
        
        if computers[i][i] == -1:
            return
        computers[i][i] = -1
        queue.append(i)
        answer += 1
        
        while(queue):
            cur = queue.popleft()
            for t in range(n):
                if computers[cur][t] == 0 or computers[cur][t] == -1:
                    continue
                computers[cur][t] = -1
                queue.append(t)
            
    
    for i in range(n):
        bfs(i)
    
    return answer