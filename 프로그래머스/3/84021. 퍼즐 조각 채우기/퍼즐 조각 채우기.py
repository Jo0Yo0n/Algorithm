from collections import deque

def solution(game_board, table):
    def normalize(shape):
        min_r = min(r for r, _ in shape)
        min_c = min(c for _, c in shape)
        
        normalized = [(r - min_r, c - min_c) for r, c in shape]
        normalized.sort()
        return normalized
    
    def rotate(shape):
        rotated = [(-c, r) for r, c in shape]
        return normalize(rotated)
    
    def is_match(shapeA, shapeB):
        cur = shapeB
        
        for _ in range(4):
            if cur == shapeA:
                return True
            cur = rotate(cur)
        
        return False
    
    def bfs(board, target):
        dr = [1, 0, -1, 0]
        dc = [0, 1, 0, -1]
        
        length = len(board)
        queue = deque()
        visited = [[False] * length for _ in range(length)]
        
        pieces = []
        
        for r in range(length):
            for c in range(length):
                if board[r][c] != target or visited[r][c]:
                    continue
                
                queue.append((r, c))
                visited[r][c] = True
                piece = [(r, c)]
                
                while queue:
                    cr, cc = queue.popleft()
                    
                    for i in range(4):
                        nr = cr + dr[i]
                        nc = cc + dc[i]
                        
                        if not (0 <= nr < length and 0 <= nc < length):
                            continue
                        if board[nr][nc] != target or visited[nr][nc]:
                            continue
                        
                        queue.append((nr, nc))
                        visited[nr][nc] = True
                        piece.append((nr, nc))
                                        
                pieces.append(normalize(piece))
        return pieces
    
    empties = bfs(game_board, 0)
    puzzles = bfs(table, 1)
    used = [False] * len(puzzles)
    
    answer = 0
    
    for empty in empties:
        for i in range(len(puzzles)):
            if used[i]:
                continue
            if len(empty) != len(puzzles[i]):
                continue
            
            if is_match(empty, puzzles[i]):
                answer += len(puzzles[i])
                used[i] = True
                break
    
    return answer