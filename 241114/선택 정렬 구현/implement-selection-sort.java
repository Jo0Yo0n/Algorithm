import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++) {

            int min = i;
            for(int j = i + 1; j < n; j++) {

                if(arr[min] > arr[j]) {

                    int temp = min;
                    min = j;
                    j = temp;
                }
            }
            
            if(min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}