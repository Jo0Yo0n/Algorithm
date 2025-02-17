import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        int a = 0;
        
        for(int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[length];
            int t = 0;
            
            int start = commands[i][0] - 1;
            while(t < length) {
                temp[t++] = array[start++];
            }
            
            Arrays.sort(temp);
            ans[a++] = temp[commands[i][2] - 1];
        }
        
        return ans;
    }
}