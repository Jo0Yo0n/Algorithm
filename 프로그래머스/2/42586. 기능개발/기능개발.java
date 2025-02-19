import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int cur = 0;
        List<Integer> list = new ArrayList<>();
        
        while(progresses[progresses.length - 1] != -1) {
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            int count = 0;
            
            while(cur < progresses.length && progresses[cur] >= 100) {
                count++;
                progresses[cur] = -1;
                cur++;
            }
            
            if(count != 0) {
                list.add(count);   
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}