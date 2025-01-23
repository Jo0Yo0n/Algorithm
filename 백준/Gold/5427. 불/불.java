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
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0 ,-1};

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            boolean isFinished = false;

            char[][] map = new char[h][w];
            int[][] dist_f = new int[h][w];
            int[][] dist_s = new int[h][w];

            for(int j = 0; j < h; j++) {
                Arrays.fill(dist_f[j], -1);
                Arrays.fill(dist_s[j], -1);
            }

            Deque<Pos> deque = new ArrayDeque<>();
            Pos sg = null;

            for(int j = 0; j < h; j++) {
                String temp = br.readLine();
                for(int k = 0; k < w; k++) {
                    map[j][k] = temp.charAt(k);

                    if(map[j][k] == '@') {
                        sg = new Pos(j, k);
                        dist_s[j][k] = 0;
                    }
                    else if(map[j][k] == '*') {
                        deque.addFirst(new Pos(j, k));
                        dist_f[j][k] = 0;
                    }
                }
            }

            while(!deque.isEmpty()) {
                Pos now = deque.pollLast();

                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(map[nx][ny] == '#' || dist_f[nx][ny] >= 0) continue;

                    dist_f[nx][ny] = dist_f[now.x][now.y] + 1;
                    deque.addFirst(new Pos(nx, ny));
                }
            }

            deque.addFirst(sg);
            while(!deque.isEmpty()) {
                Pos now = deque.pollLast();

                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(dist_s[now.x][now.y] + 1).append("\n");
                        
                        while(!deque.isEmpty()) deque.removeLast();
                        isFinished = true;
                        break;
                    }
                    if(map[nx][ny] == '#' || dist_s[nx][ny] >= 0) continue;
                    if(dist_f[nx][ny] != -1 && dist_s[now.x][now.y] + 1 >= dist_f[nx][ny]) continue;

                    dist_s[nx][ny] = dist_s[now.x][now.y] + 1;
                    deque.addFirst(new Pos(nx, ny));
                }
            }

            if(!isFinished) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }
}
