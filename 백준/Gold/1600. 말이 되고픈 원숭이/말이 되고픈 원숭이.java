import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w, h;
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] mx = {-1, 0, 1, 0};
        int[] my = {0, 1, 0, -1};
        int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

        int[][][] dist = new int[h][w][k + 1];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        dist[0][0][0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0));
        while(!queue.isEmpty()) {
            Pair cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + mx[i];
                int ny = cur.y + my[i];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(map[nx][ny] == 1 || dist[nx][ny][cur.count] != -1) continue;

                dist[nx][ny][cur.count] = dist[cur.x][cur.y][cur.count] + 1;
                queue.add(new Pair(nx, ny, cur.count));
            }

            if(cur.count < k) {
                for(int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];
    
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(map[nx][ny] == 1 || dist[nx][ny][cur.count + 1] != -1) continue;

                    dist[nx][ny][cur.count + 1] = dist[cur.x][cur.y][cur.count] + 1;
                    queue.add(new Pair(nx, ny, cur.count + 1));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        boolean flag = true;
        for(int i = 0; i <= k; i++) {
            if(dist[h - 1][w - 1][i] == -1) {
                continue;
            }
            else {
                flag = false;
                ans = Math.min(ans, dist[h - 1][w - 1][i]);
            }
        }

        System.out.println(flag ? -1 : ans);
    }
}
