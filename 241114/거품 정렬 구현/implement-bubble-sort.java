import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean sorted;
        do {            
            sorted = true;

            for(int i = 0; i < n - 1; i++) {

                if(arr[i] > arr[i + 1]) {

                    sorted = false;

                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        } while(!sorted);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}