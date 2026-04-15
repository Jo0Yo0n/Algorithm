import heapq

def solution(scoville, K):
    count = 0
    heapq.heapify(scoville)
    
    while len(scoville) > 1 and scoville[0] < K:
        shake = heapq.heappop(scoville) + (heapq.heappop(scoville) * 2)
        heapq.heappush(scoville, shake)
        count += 1
    
    return count if (len(scoville) >= 1 and scoville[0] >= K) else -1
