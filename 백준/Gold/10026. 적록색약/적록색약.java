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
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        
        int normal = 0;
        int cb = 0;
        char[][] paint_n = new char[n][n];  // 정상(normal)
        char[][] paint_c = new char[n][n];  // 색약(color blind)
        boolean[][] vis_n = new boolean[n][n];
        boolean[][] vis_c = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < n; j++) {
                paint_n[i][j] = temp.charAt(j);

                if(temp.charAt(j) == 'R') {
                    paint_c[i][j] = 'G';
                }
                else {
                    paint_c[i][j] = temp.charAt(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis_n[i][j]) {
                    normal++;
                    bfs(paint_n, vis_n, i, j);
                }

                if(!vis_c[i][j]) {
                    cb++;
                    bfs(paint_c, vis_c, i, j);
                }
            }
        }

        sb.append(normal).append(" ").append(cb);
        System.out.println(sb);
    }

    public static void bfs(char[][] paint, boolean[][] visit, int x, int y) {
        visit[x][y] = true;
        Deque<Pos> deque = new ArrayDeque<>();
        deque.addFirst(new Pos(x, y));

        while(!deque.isEmpty()) {
            Pos now = deque.pollLast();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visit[nx][ny] || paint[now.x][now.y] != paint[nx][ny]) continue;

                visit[nx][ny] = true;
                deque.addFirst(new Pos(nx, ny));
            }
        }
    }
}
