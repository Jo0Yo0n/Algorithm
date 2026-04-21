import heapq

def solution(operations):
    heap_size = 0
    max_heap = []
    min_heap = []
    visited = [False] * len(operations)
    
    for idx, op in enumerate(operations):
        cmd, value = op.split()
        value = int(value)
        
        if cmd == 'I':
            heapq.heappush(max_heap, (-value, idx))
            heapq.heappush(min_heap, (value, idx))
            
        else:
            if value == 1:
                while max_heap and visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    _, idx = heapq.heappop(max_heap)
                    visited[idx] = True
            else:
                while min_heap and visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    _, idx = heapq.heappop(min_heap)
                    visited[idx] = True
        
    while max_heap and visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
        
    if not max_heap and not min_heap:
        return [0, 0]
    
    return [-max_heap[0][0], min_heap[0][0]]