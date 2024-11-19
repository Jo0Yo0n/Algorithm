import java.util.*;
import java.io.*;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void heapSort(int n) {

        for(int i = n / 2 - 1; i >= 0; i--) {

            heapify(n, i);
        }

        for(int i = n - 1; i > 0; i--) {

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(i, 0);
        }
    }

    public static void heapify(int n, int i) {

        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if(l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if(r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(n, largest);
        }
    }
}