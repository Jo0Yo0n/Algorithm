from collections import deque

def bfs(start, graph, visited):
    q = deque([start])
    visited[start] = True
    count = 1
    
    while q:
        current = q.popleft()
        
        for node in graph[current]:
            if visited[node]:
                continue
            
            count += 1
            q.append(node)
            visited[node] = True
    return count
        

def solution(n, wires):
    answer = n
    
    for i in range(len(wires)):
        graph = [[] for _ in range(n + 1)]
        for j in range(len(wires)):
            if i == j:
                continue
            a, b = wires[j]
            graph[a].append(b)
            graph[b].append(a)
    
        visited = [False] * (n + 1)
        count = bfs(1, graph, visited)
        
        answer = min(answer, abs(n - 2 * count))
    
    return answer