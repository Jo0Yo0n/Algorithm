import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int seconds = 0;
        int[] bridge = new int[bridge_length];
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int truck : truck_weights) {
            deque.addLast(truck);
        }
        
        while(!deque.isEmpty() || checkBridgeWeight(bridge) > 0) {
            seconds++;
            moveTruck(bridge);
            if(!deque.isEmpty() && checkBridgeWeight(bridge) + deque.peekFirst() <= weight) {
                bridge[0] = deque.pollFirst();
            }
        }
        
        return seconds;
    }
    
    public int checkBridgeWeight(int[] bridge) {
        int weight = 0;
        
        for(int w : bridge) {
            weight += w;
        }
        
        return weight;
    }
    
    public void moveTruck(int[] bridge) {
        for(int i = bridge.length - 1; i > 0; i--) {
             bridge[i] = bridge[i - 1];
        }
        
        bridge[0] = 0;
    }
}