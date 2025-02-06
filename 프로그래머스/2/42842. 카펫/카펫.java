import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] sol = new int[2];
        
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0) {
                if((i * 2) + ((yellow / i) * 2) + 4 == brown) {
                    sol[0] = (yellow / i) + 2;
                    sol[1] = i + 2;
                    return sol;
                }
            }
        }
        
        return sol;
    }
}