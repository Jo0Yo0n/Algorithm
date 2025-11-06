import heapq

def solution(jobs):
    clock = 0
    jobs = [(j[1], j[0]) for j in jobs]
    jobs.sort(key = lambda x: -x[1])
    heap = []
    duration_sum = 0
    count = len(jobs)
    
    while jobs or heap:
        while jobs and jobs[-1][1] <= clock:
            heapq.heappush(heap, jobs.pop())
            
        if heap:
            job = heapq.heappop(heap)
            clock += job[0]
            duration_sum += clock - job[1]
        else:
            clock = jobs[-1][1]
        
    
    return duration_sum // count