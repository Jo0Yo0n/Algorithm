from collections import deque

def solution(bridge_length, weight, truck_weights):
    time = 0
    current_weight = 0
    bridge_queue = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)
    
    while truck_weights:
        current_weight -= bridge_queue.popleft()
        
        if truck_weights[0] + current_weight <= weight:
            truck = truck_weights.popleft()
            current_weight += truck
            bridge_queue.append(truck)
            
        else:
            bridge_queue.append(0)
            
        time += 1
        
    return time + bridge_length