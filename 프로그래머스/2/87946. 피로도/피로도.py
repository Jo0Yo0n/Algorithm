def back_tracking(k, dungeons, visited, answer):
    
    for idx, dungeon in enumerate(dungeons):
        if any(idx == v for v in visited) or k < dungeon[0]:
            continue
        if k >= dungeon[0]:
            visited.append(idx)
            k -= dungeon[1]
            answer = max(answer, len(visited))
            
            answer = back_tracking(k, dungeons, visited, answer)
            
            visited.pop()
            k += dungeon[1]

    return answer

def solution(k, dungeons):
    answer = 0
    visited = []
    
    return back_tracking(k, dungeons, visited, answer)    
