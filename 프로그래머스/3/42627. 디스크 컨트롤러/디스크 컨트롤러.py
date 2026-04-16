from collections import deque

def solution(jobs):
    time = 0
    time_sum = 0
    num_jobs = len(jobs)
    
    while jobs:
        sorted_jobs = deque()
        for idx, (s, l) in enumerate(jobs):
            if s <= time:
                sorted_jobs.append([idx, s, l])
        if not sorted_jobs:
            time += 1
            continue
        
        sorted_jobs = deque(sorted(sorted_jobs, key=lambda x: (x[2], x[1], x[0])))
        
        picked_job = sorted_jobs.popleft()
        time += picked_job[2]
        time_sum += time - picked_job[1]
        jobs.pop(picked_job[0])
        
    return time_sum // num_jobs