import java.util.*;

class Solution {
    public boolean[] visited = new boolean[8];
    public int[] dMax = new int[100000];
    public int m = 0;
    public int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        
        backtracking(0, k);
        
        int max = 0;
        
        for(int i = 0; dMax[i] != 0; i++) {
            if(dMax[i] > max) max = dMax[i];
        }
        
        return max;
    }
    
    public void backtracking(int count, int k) {
        for(int i = 0; i < dungeons.length; i++) {
            if(k == 0) {
                dMax[m++] = count;
                return;
            }
            
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                backtracking(count + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
            if(i == dungeons.length - 1) dMax[m++] = count;
        }
    }
}