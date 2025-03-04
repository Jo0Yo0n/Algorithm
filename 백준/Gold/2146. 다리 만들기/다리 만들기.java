import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(x: " + x + ", y: " + y + ")";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> wait = new  LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    number++;
                    visited[i][j] = true;
                    map[i][j] = number;
                    queue.add(new Pair(i, j));

                    while(!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        boolean isTouched = false;

                        for(int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(visited[nx][ny]) continue;
                            if(map[nx][ny] == 0) {
                                isTouched = true;
                                continue;
                            }

                            visited[nx][ny] = true;
                            map[nx][ny] = number;
                            queue.add(new Pair(nx, ny));
                        }

                        if(isTouched) {
                            wait.add(new Pair(cur.x, cur.y));
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while(!wait.isEmpty()) {
            Pair tile = wait.poll();
            int comp = map[tile.x][tile.y];
            boolean isFinished = false;

            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            queue.add(tile);
            while(!queue.isEmpty()) {
                Pair cur = queue.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(map[nx][ny] != 0 && map[nx][ny] != comp) {
                        ans = Math.min(ans, dist[cur.x][cur.y]);
                        isFinished = true;
                        while(!queue.isEmpty()) {
                            queue.remove();
                        }
                        break;
                    }
                    if(map[nx][ny] != 0 || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.add(new Pair(nx, ny));
                }
                if(isFinished) break;
            }
        }

        System.out.println(ans);
    }
}