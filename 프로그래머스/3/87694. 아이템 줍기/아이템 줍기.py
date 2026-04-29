from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    SCALE = 2
    MAX_SIZE = 101
    board = [[0] * MAX_SIZE for _ in range(MAX_SIZE)]
    visited = [[False] * MAX_SIZE for _ in range(MAX_SIZE)]
    
    for x1, y1, x2, y2 in rectangle:
        x1 *= SCALE
        y1 *= SCALE
        x2 *= SCALE
        y2 *= SCALE
        
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                if x1 < x < x2 and y1 < y < y2:
                    board[x][y] = 2
                elif board[x][y] != 2:
                    board[x][y] = 1
    
    characterX *= SCALE
    characterY *= SCALE
    itemX *= SCALE
    itemY *= SCALE
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    queue = deque([(characterX, characterY, 0)])
    visited[characterX][characterY] = True
    
    while queue:
        curX, curY, dist = queue.popleft()
        
        if curX == itemX and curY == itemY:
            return dist // SCALE
        
        for i in range(4):
            nxtX = curX + dx[i]
            nxtY = curY + dy[i]
            
            if not (0 <= nxtX < MAX_SIZE and 0 <= nxtY < MAX_SIZE):
                continue
            
            if visited[nxtX][nxtY] or board[nxtX][nxtY] != 1:
                continue
            
            queue.append((nxtX, nxtY, dist + 1))
            visited[nxtX][nxtY] = True
    
    