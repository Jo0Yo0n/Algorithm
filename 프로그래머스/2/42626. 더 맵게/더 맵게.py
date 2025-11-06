import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    ans = 0
    
    while len(scoville) >= 2:
        min1 = heapq.heappop(scoville)
        
        if min1 >= K:
            return ans
        else:
            min2 = heapq.heappop(scoville)
            heapq.heappush(scoville, min1 + (min2 * 2))
            ans += 1
    
    if scoville[0] >= K:
        return ans
    else:
        return -1