import java.util.*;
import java.io.*;

class Pos {
    public int x;
    public int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Pos o) {
        if(this.x == o.x && this.y == o.y) return true;
        else return false;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

        for(int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] board = new int[l][l];
            for(int j = 0; j < l; j++) {
                Arrays.fill(board[j], -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            Pos knight = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            board[knight.x][knight.y] = 0;
            st = new StringTokenizer(br.readLine());
            Pos target = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Deque<Pos> deque = new ArrayDeque<>();
            deque.addFirst(knight);

            while(!deque.isEmpty()) {
                Pos now = deque.pollLast();
                if(now.equals(target)) {
                    sb.append(board[now.x][now.y]).append("\n");
                    break;
                }

                for(int j = 0; j < 8; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if(board[nx][ny] >= 0) continue;

                    board[nx][ny] = board[now.x][now.y] + 1;
                    deque.addFirst(new Pos(nx, ny));
                }
            }
        }

        System.out.println(sb);
    }
}
