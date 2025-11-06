import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    is_deleted = {}
    op_id = 0
    
    for operation in operations:
        o, d = operation.split()
        
        if o == "I":
            d = int(d)
            heapq.heappush(min_heap, (d, op_id))
            heapq.heappush(max_heap, (-d, op_id))
            is_deleted[op_id] = False
            op_id += 1
            
        else:
            if d == "1":
                while max_heap and is_deleted[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                
                if max_heap:
                    is_deleted[heapq.heappop(max_heap)[1]] = True
                    
            else:
                while min_heap and is_deleted[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                
                if min_heap:
                    is_deleted[heapq.heappop(min_heap)[1]] = True

    while max_heap and is_deleted[max_heap[0][1]]:
        heapq.heappop(max_heap)
    
    while min_heap and is_deleted[min_heap[0][1]]:
        heapq.heappop(min_heap)
    
    if min_heap and max_heap:
        return [-max_heap[0][0], min_heap[0][0]]
    else:
        return [0, 0]
        
            