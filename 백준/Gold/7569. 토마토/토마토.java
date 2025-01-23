import java.util.*;
import java.io.*;

class Pos {
    public int h;
    public int r;
    public int c;
    
    public Pos(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        int[][][] day = new int[h][n][m];
        int[] dr = {-1, 0, 1, 0, 0, 0};
        int[] dc = {0, 1, 0, -1, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1};

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(day[i][j], -1);
            }
        }

        Deque<Pos> deque = new ArrayDeque<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if(box[i][j][k] == 1) {
                        deque.addFirst(new Pos(i, j, k));
                        day[i][j][k] = 0;
                    }
                }
            }
        }

        while(!deque.isEmpty()) {
            Pos now = deque.pollLast();

            for(int i = 0; i < 6; i++) {
                int nh = now.h + dh[i];
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || nh < 0 || nh >= h) continue;
                if(box[nh][nr][nc] == -1) continue;
                if(day[nh][nr][nc] != -1 && day[nh][nr][nc] <= day[now.h][now.r][now.c] + 1) continue;
                
                day[nh][nr][nc] = day[now.h][now.r][now.c] + 1;
                box[nh][nr][nc] = 1;
                deque.addFirst(new Pos(nh, nr, nc));
            }
        }

        int ans = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if(ans < day[i][j][k]) {
                        ans = day[i][j][k];
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
