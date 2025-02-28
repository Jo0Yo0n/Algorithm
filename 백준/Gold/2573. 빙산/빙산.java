import java.util.*;
import java.io.*;

public class Main {
    public static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        int[][] year = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pieces;
        int count;
        while(true) {
            ans++;
            pieces = 0;
            count = 0;
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            Deque<Pair> deque = new ArrayDeque<>();

            // 녹는 양 확인
            int[][] melt = new int[n][m];
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j < m - 1; j++) {
                    int water = 0;
                    if(arr[i][j] != 0) {
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(arr[nx][ny] == 0) water++;
                        }
                        melt[i][j] = water;
                    }
                }
            }

            // 녹이기
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j < m - 1; j++) {
                    if(arr[i][j] != 0) {
                        arr[i][j] = Math.max(0, arr[i][j] - melt[i][j]);
                    }
                }
            }

            // 조각 개수 세기 + 빙하 개수 세기기
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j < m - 1; j++) {
                    if(arr[i][j] != 0 && year[i][j] < ans) {
                        year[i][j] = ans;
                        pieces++;
                        count++;
                        deque.addLast(new Pair(i, j));

                        while(!deque.isEmpty()) {
                            Pair cur = deque.pollFirst();
                            int water = 0;

                            for(int k = 0; k < 4; k++) {
                                int nx = cur.x + dx[k];
                                int ny = cur.y + dy[k];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if(arr[nx][ny] == 0 || year[nx][ny] >= ans) continue;
                                
                                year[nx][ny] = ans;
                                count++;
                                deque.addLast(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }
            if(pieces >= 2 || count == 0) break;
        }

        System.out.println((count == 0) ? 0 : ans);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}