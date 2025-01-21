import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int su = Integer.parseInt(st.nextToken());
        int ds = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        deque.addFirst(su);
        visited[su] = 0;

        while(true) {
            int now = deque.pollLast();

            if(now == ds) {
                System.out.println(visited[now]);
                return;
            }

            if(now - 1 >= 0 && visited[now - 1] == -1) {
                deque.addFirst(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if(now + 1 <= 100000 && visited[now + 1] == -1) {
                deque.addFirst(now + 1);
                visited[now + 1] = visited[now] + 1;
            }
            if(now * 2 <= 100000 && visited[now * 2] == -1) {
                deque.addFirst(now * 2);
                visited[now * 2] = visited[now] + 1;
            }
        }
    }
}
