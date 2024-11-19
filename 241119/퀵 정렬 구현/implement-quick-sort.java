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

        quickSort(0, n - 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {

            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void quickSort(int low, int high) {

        if(low < high) {
            int pos = partition(low, high);

            quickSort(low, pos - 1);
            quickSort(pos + 1, high);
        }
    }

    public static int partition(int low, int high) {

 
        pivoting(low, high);

        int pivot = arr[high];

        int j = low;
        for(int i = low; i < high; i++) {

            if(arr[i] < pivot) {
            
                swap(i, j);

                j++;
            }
        }
        swap(j, high);

        return j;

    }

    public static void pivoting(int low, int high) {

        int mid = (low + high) / 2;

        // 원소의 개수가 3개 이하일 때
        if (high - low <= 2) {
            return;
        }
        else {
            
            int[] tempArr = {low, mid, high};

            // 정렬
            for(int i = 0; i < 2; i++) {

                int min = i;
                for(int j = i + 1; j < 3; j++) {

                    if(arr[min] > arr[j]) {
                        min = j;
                    }
                }

                int temp = tempArr[min];
                tempArr[min] = tempArr[i];
                tempArr[i] = temp;
            }

            // 중간값을 맨 뒤 원소와 교체
            int temp = arr[tempArr[1]];
            arr[tempArr[1]] = arr[high];
            arr[high] = temp;
        }
    }

    public static void swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return;
    }
}