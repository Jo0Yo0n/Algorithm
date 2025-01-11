import java.util.*;
import java.io.*;

class Pos {

    public int x, y;

    public Pos(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {

            String input = br.readLine();

            for(int j = 1; j <= m; j++) {

                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int[][] dist = new int[n + 1][m + 1];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Pos> deque = new ArrayDeque<>();

        deque.addFirst(new Pos(1, 1));
        dist[1][1] = 1;
        while(!deque.isEmpty()) {

            Pos now = deque.pollLast();

            for(int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                if(maze[nx][ny] == 0) continue;

                maze[nx][ny] = 0;
                deque.addFirst(new Pos(nx, ny));
                dist[nx][ny] = dist[now.x][now.y] + 1;
            }
        }

        System.out.println(dist[n][m]);
    }
}