from collections import deque

def solution(maps):
    r = len(maps)
    c = len(maps[0])
    
    visited = [[False] * c for _ in range(r)]
    
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    
    queue = deque()
    queue.append((0, 0, 1))

    while queue:
        cur_row, cur_col, cur_count = queue.popleft()
        
        for i in range(4):
            nr = cur_row + dr[i]
            nc = cur_col + dc[i]

            if nr < 0 or nc < 0 or nr >= r or nc >= c:
                continue
            if maps[nr][nc] == 0 or visited[nr][nc]:
                continue
            if nr == r - 1 and nc == c - 1:
                return cur_count + 1
            
            visited[nr][nc] = True
            queue.append((nr, nc, cur_count + 1))
    
    return -1
            