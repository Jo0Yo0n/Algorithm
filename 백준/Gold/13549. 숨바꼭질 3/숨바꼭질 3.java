import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
            return;
        }

        int[] street = new int[100001];
        Arrays.fill(street, -1);
        street[n] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur - 1 >= 0) {
                int temp = street[cur - 1];
                street[cur - 1] = (street[cur - 1] == -1) ? street[cur] + 1 : Math.min(street[cur - 1], street[cur] + 1);
                
                if(cur - 1 != k && temp != street[cur - 1]) {
                    queue.add(cur - 1);
                }
            }
            if(cur + 1 <= 100000) {
                int temp = street[cur + 1];
                street[cur + 1] = (street[cur + 1] == -1) ? street[cur] + 1 : Math.min(street[cur + 1], street[cur] + 1);
                
                if(cur + 1 != k && temp != street[cur + 1]) {
                    queue.add(cur + 1);
                }
            }
            if(cur * 2 <= 100000) {
                int temp = street[cur * 2];
                street[cur * 2] = (street[cur * 2] == -1) ? street[cur] : Math.min(street[cur * 2], street[cur]);

                if(cur * 2 != k && temp != street[cur * 2]) {
                    street[cur * 2] = Math.min(street[cur], street[cur * 2]);
                    queue.add(cur * 2);
                }
            }
        }

        System.out.println(street[k]);
    }
}
