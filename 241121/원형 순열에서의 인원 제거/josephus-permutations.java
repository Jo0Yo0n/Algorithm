import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {

            queue.add(i);
        }

        while(queue.size() != 1) {

            for(int i = 0; i < k - 1; i++) {

                int temp = queue.poll();
                queue.add(temp);
            }

            sb.append(queue.poll()).append(" ");
        }
        sb.append(queue.poll());

        System.out.println(sb);
    }
}