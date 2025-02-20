import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] pri = new int[10];
        Deque<Pair> deque = new ArrayDeque<>();
        Pair[] seq = new Pair[priorities.length];
        int s = 0;
        
        for(int i = 0; i < priorities.length; i++) {
            deque.addLast(new Pair(priorities[i], i));
            pri[priorities[i]]++;
        }

        while(!deque.isEmpty()) {
            Pair now = deque.peekFirst();
            
            int max = -1;
            for(int i = now.priority + 1; i <= 9; i++) {
                if(pri[i] > 0 && max < i) max = i;
            }
            
            if(max == -1) {
                seq[s++] = deque.pollFirst();
                pri[now.priority]--;
            }
            else {
                while(max != deque.peekFirst().priority) {
                    deque.addLast(deque.pollFirst());
                }
            }
        }
        
        int ans = 1;
        for(int i = 0; i < seq.length; i++) {
            if(location == seq[i].seq) break;
            ans++;
        }
        
        return ans;
    }
}

class Pair {
    public int priority;
    public int seq;
    
    public Pair(int priority, int seq) {
        this.priority = priority;
        this.seq = seq;
    }
    
    public String toString() {
        return "("+ priority + ", " + seq + ")";
    }
}