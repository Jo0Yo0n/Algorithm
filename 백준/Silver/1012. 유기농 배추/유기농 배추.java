import java.util.*;
import java.io.*;

class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int worm = 0;

            int[][] field = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
            }

            Deque<Pos> deque = new ArrayDeque<>();

            for(int a = 0; a < n; a++) {
                for(int b = 0; b < m; b++) {
                    if(field[a][b] == 0 || visited[a][b]) continue;

                    visited[a][b] = true;
                    deque.addFirst(new Pos(a, b));
                    worm++;
                    while(!deque.isEmpty()) {
                        Pos now = deque.pollLast();

                        for(int c = 0; c < 4; c++) {
                            int nx = now.x + dx[c];
                            int ny = now.y + dy[c];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(field[nx][ny] == 0 || visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            deque.addFirst(new Pos(nx, ny));
                        }
                    }
                }
            }

            sb.append(worm).append("\n");
        }

        System.out.println(sb);
    }
}
