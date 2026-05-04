def solution(tickets):
    tickets.sort()
    used = [False] * len(tickets)
    
    def back_tracking(cur, route):
        if len(route) == len(tickets) + 1:
            return route
        
        for i in range(len(tickets)):
            departure, arrival = tickets[i]
            
            if cur != departure:
                continue
            if used[i]:
                continue
            
            route.append(arrival)
            used[i] = True
            result = back_tracking(arrival, route)
            if result:
                return result
            route.pop()
            used[i] = False
        
        return None
    
    return back_tracking("ICN", ["ICN"])