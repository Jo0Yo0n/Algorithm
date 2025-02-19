import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {        
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        
        for(int i : arr) {
            if(deque.isEmpty()) {
                deque.addFirst(i);
                count++;
            }
            else if(!deque.isEmpty() && deque.peekFirst() != i) {
                deque.addFirst(i);
                count++;
            }
        }
        
        int[] answer = new int[count];
        int i = 0;
        
        while(i < count) {
            answer[i++] = deque.pollLast();
        }

        return answer;
    }
}