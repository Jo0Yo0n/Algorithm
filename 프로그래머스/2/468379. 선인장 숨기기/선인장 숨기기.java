import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1;
        int[][] time = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            Arrays.fill(time[r], INF);
        }
        
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            
            time[r][c] = i + 1;
        }
        
        int[][] rowMin = horizontalSlidingMin(time, w);
        int[][] rectMin = verticalSlidingMin(rowMin, h);
        
        int ansR = 0;
        int ansC = 0;
        int best = -1;
        
        for(int r = 0; r < m - h + 1; r++) {
            for(int c = 0; c < n - w + 1; c++) {
                if(best < rectMin[r][c]) {
                    best = rectMin[r][c];
                    ansR = r;
                    ansC = c;
                }
            }
        }
        
        return new int[]{ansR, ansC};
    }
    
    int[][] horizontalSlidingMin(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[rows][cols - k + 1];
        
        for(int r = 0; r < rows; r++) {
            Deque<Integer> deque = new ArrayDeque<>();
            
            for(int c = 0; c < cols; c++) {
                while(!deque.isEmpty() && deque.peekFirst() <= c - k) {
                    deque.pollFirst();
                }
                
                while(!deque.isEmpty() && arr[r][deque.peekLast()] >= arr[r][c]) {
                    deque.pollLast();
                }
                
                deque.offerLast(c);
                
                if(c >= k - 1) {
                    result[r][c - k + 1] = arr[r][deque.peekFirst()];
                }
            }
        }
        
        return result;
    }
    
    int[][] verticalSlidingMin(int[][] arr, int k) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[rows - k + 1][cols];
        
        for(int c = 0; c < cols; c++) {
            Deque<Integer> deque = new ArrayDeque<>();
            
            for(int r = 0; r < rows; r++) {
                while(!deque.isEmpty() && deque.peekFirst() <= r - k) {
                    deque.pollFirst();
                }
                
                while(!deque.isEmpty() && arr[deque.peekLast()][c] >= arr[r][c]) {
                    deque.pollLast();
                }
                
                deque.offerLast(r);
                
                if(r >= k - 1) {
                    result[r - k + 1][c] = arr[deque.peekFirst()][c];
                }
            }
        }
        
        return result;
    }
}