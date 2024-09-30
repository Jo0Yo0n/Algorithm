import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int min = 1000001;
            int max = -1000001;

            for(int j = 0; j < N; j++) {
                
                if (arr[j] < min) {
                    min = arr[j];
                }

                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
