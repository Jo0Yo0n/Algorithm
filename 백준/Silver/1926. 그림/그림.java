import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;
    public static int[][] page;
    public static int area;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        page = new int[n][m];

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {

                page[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                area = 0;

                if(dfs(i, j) != 0) {
                    
                    count++;

                    if(area > max) max = area;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        sb.append(max).append("\n");

        System.out.println(sb);
    }

    public static int dfs(int x, int y) {

        if(x < 0 || x >= n || y < 0 || y >= m) return 0;

        if(page[x][y] == 1) {

            page[x][y] = 0;
            area++;

            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x + 1, y);
            dfs(x, y - 1);

            return area;
        }
        else {
            return 0;
        }
    }
}
