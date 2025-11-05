def solution(bridge_length, weight, truck_weights):
    bridge = []
    truck_queue = [[tw, bridge_length] for tw in truck_weights]
    clock = 0
    
    def cur_bridge_weight():
        sum = 0
        for b in bridge:
            sum += b[0]
        return sum
    def tick_tack():
        for b in bridge:
            b[1] -= 1
    
    while truck_queue or bridge:
        while(bridge and bridge[0][1] == 0):
            bridge.pop(0)
        
        if truck_queue and (weight - cur_bridge_weight()) >= truck_queue[0][0]:
            bridge.append(truck_queue.pop(0))
        
        tick_tack()
        clock += 1
        
    return clock