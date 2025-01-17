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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r, c;
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        char[][] maze = new char[r][c];
        int[][] jihun = new int[r][c];
        int[][] fire = new int[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Pos> jDeque = new ArrayDeque<>();
        Deque<Pos> fDeque = new ArrayDeque<>();

        for(int i = 0; i < r; i++) {
            Arrays.fill(jihun[i], -1);
            Arrays.fill(fire[i], -1);
        }

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                maze[i][j] = line.charAt(j);

                if(maze[i][j] == 'J') {
                    jihun[i][j] = 0;
                    jDeque.addFirst(new Pos(i, j));
                }
                else if(maze[i][j] == 'F') {
                    fire[i][j] = 0;
                    fDeque.addFirst(new Pos(i, j));
                }
            }
        }

        while(!fDeque.isEmpty()) {
            Pos now = fDeque.pollLast();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(maze[nx][ny] == '#') continue;
                if(fire[nx][ny] >= 0) continue;

                fire[nx][ny] = fire[now.x][now.y] + 1;
                fDeque.addFirst(new Pos(nx, ny));
            }
        }

        while(!jDeque.isEmpty()) {
            Pos now = jDeque.pollLast();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(jihun[now.x][now.y] + 1);
                    return;
                }
                if(maze[nx][ny] == '#') continue;
                if(jihun[nx][ny] >= 0) continue;
                if(fire[nx][ny] != -1 && jihun[now.x][now.y] + 1 >= fire[nx][ny]) {
                    jihun[nx][ny] = 0;
                    continue;
                }

                jihun[nx][ny] = jihun[now.x][now.y] + 1;
                jDeque.addFirst(new Pos(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
