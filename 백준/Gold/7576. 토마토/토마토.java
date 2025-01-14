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

        int m, n;
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];
        int[][] day = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0 ,-1};

        for(int i = 0; i < n; i++) {
            Arrays.fill(day[i], -1);
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    day[i][j] = 0;
                }
            }
        }

        Deque<Pos> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0 || box[i][j] == -1) continue;
                if(day[i][j] != 0) continue;    // 처음부터 익은 토마토가 아닌 경우 배제

                deque.addFirst(new Pos(i, j));
            }
        }

        while(!deque.isEmpty()) {
            Pos now = deque.pollLast();
            
            for(int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(box[nx][ny] == -1) continue;
            
                if(day[nx][ny] == -1 || day[nx][ny] > day[now.x][now.y] + 1) {
                    day[nx][ny] = day[now.x][now.y] + 1;
                    deque.addFirst(new Pos(nx, ny));
                    box[nx][ny] = 1;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(day[i][j] > ans) {
                    ans = day[i][j];
                }
            }
        }

        System.out.println(ans);
    }
}
