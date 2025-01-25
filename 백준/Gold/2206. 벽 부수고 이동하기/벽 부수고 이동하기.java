import java.util.*;
import java.io.*;

class Pos {
    public int x;
    public int y;
    public int broken;
    public Pos(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        int[][][] dist = new int[n + 1][m + 1][2];
        dist[1][1][0] = dist[1][1][1] = 1;

        for(int i = 1; i <= n; i++) {
            String temp = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
            }
        }

        Deque<Pos> deque = new ArrayDeque<>();
        deque.addFirst(new Pos(1, 1, 0));

        while(!deque.isEmpty()) {
            Pos now = deque.pollLast();
            int nextDist = dist[now.x][now.y][now.broken] + 1;

            if(now.x == n && now.y == m) {
                System.out.println(dist[now.x][now.y][now.broken]);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if(map[nx][ny] == 0 && dist[nx][ny][now.broken] == 0) {
                    dist[nx][ny][now.broken] = nextDist;
                    deque.addFirst(new Pos(nx, ny, now.broken));
                }
                if(now.broken != 1 && map[nx][ny] == 1 && dist[nx][ny][now.broken] == 0) {
                    dist[nx][ny][1] = nextDist;
                    deque.addFirst(new Pos(nx, ny, 1));
                }
            }
        }

        System.out.println(-1);
    }
}
