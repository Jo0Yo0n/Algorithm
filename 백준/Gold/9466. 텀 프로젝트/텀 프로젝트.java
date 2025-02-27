import java.util.*;
import java.io.*;

public class Main {
    public static int[] next;
    public static int[] state;
    public static final int NOT_VISITED = 0;
    public static final int CYCLE = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            next = new int[n + 1];
            state = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if(state[i] == NOT_VISITED) {
                    find(i);
                }
            }

            int ans = 0;
            for(int i = 1; i <= n; i++) {
                if(state[i] != CYCLE) {
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
    
    public static void find(int x) {
        int cur = x;
        while(true) {
            state[cur] = x;
            cur = next[cur];

            if(state[cur] == x) {
                while(state[cur] != CYCLE) {
                    state[cur] = CYCLE;
                    cur = next[cur];
                }
                return;
            }
            else if(state[cur] != NOT_VISITED) {
                return;
            }
        }
    }
}