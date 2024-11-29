import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {

            int a = Integer.parseInt(st.nextToken());

            if(target - a > 0 && arr[target - a]) answer++;

            arr[a] = true;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
}