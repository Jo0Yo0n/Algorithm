import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                deque.addLast('(');
            }
            else if(!deque.isEmpty() && deque.peekFirst() == '(') {
                deque.removeFirst();
            }
            else {
                return false;
            }
        }
        
        if(!deque.isEmpty()) {
            return false;
        }
        
        return true;
    }
}