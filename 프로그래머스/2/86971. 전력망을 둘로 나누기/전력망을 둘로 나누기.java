import java.util.*;

class Solution {
    public List<Integer>[] graph;
    public int min;
    
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] arr : wires) {
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        
        for(int[] arr : wires) {
            boolean[] visited = new boolean[n + 1];
            
            graph[arr[0]].remove(Integer.valueOf(arr[1]));
            graph[arr[1]].remove(Integer.valueOf(arr[0]));
            
            int cnt = bfs(1, visited);
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
            
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        
        return min;
    }
    
    public int bfs(int v, boolean[] visited) {
        visited[v] = true;
        int ret = 1;
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(v);
        
        while(!deque.isEmpty()) {
            int s = deque.pollLast();
            Iterator<Integer> iter = graph[s].iterator();
            
            while(iter.hasNext()) {
                int i = iter.next();
                if(!visited[i]) {
                    visited[i] = true;
                    deque.addFirst(i);
                    ret++;
                }
            }
        }
        
        return ret;
    }
}