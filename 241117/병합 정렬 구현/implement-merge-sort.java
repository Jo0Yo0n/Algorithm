import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        
        if (low < high) {

            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] sortedArr = new int[arr.length];

        while(i <= mid && j <= high) {

            if(arr[i] < arr[j]) {

                sortedArr[k++] = arr[i++];
            }
            else {

                sortedArr[k++] = arr[j++];
            }
        }

        while(i <= mid) {

            sortedArr[k++] = arr[i++];
        }

        while(j <= high) {

            sortedArr[k++] = arr[j++];
        }

        for(int l = low; l <= high; l++) {
            arr[l] = sortedArr[l];
        }
    }
}