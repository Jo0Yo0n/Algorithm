from collections import deque

def solution(begin, target, words):
    visited = set()
    
    def is_transformable(word1, word2):
        count = 0
        for i in range(len(word1)):
            if word1[i] != word2[i]:
                count += 1     
        return count == 1
    
    def bfs(start):
        count = 0
        queue = deque()
        queue.append((start, 0))
        visited.add(start)
        
        while queue:
            cur, dist = queue.popleft()
            if cur == target:
                return dist
        
            for word in words:
                if not is_transformable(cur, word) or word in visited:
                    continue
                
                queue.append((word, dist + 1))
                visited.add(word)
        
        return 0
    
    return bfs(begin) 
        