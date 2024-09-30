import java.util.*;
import java.io.*;

// 1. 테스트 케이스의 개수를 입력받는다.
// 2. 테스트 케이스의 개수만큼 for문으로 반복한다.
//   2-1. 정수의 개수(N)를 입력받는다.
//   2-2. N개의 정수를 공백으로 구분해서 입력받아 배열(arr)에 저장한다.
//   2-3. 최댓값, 최솟값 변수를 선언하고 각각 -1000001, 1000001로 초기화 한다.
//   2-4. N만큼 for문으로 반복한다.
//     2-4-1. arr[i]에 저장된 정수가 최솟값보다 작으면 최솟값을 arr[i]로 바꾼다.
//     2-4-2. arr[i]에 저장된 정수가 최댓값보다 크다면 최댓값을 arr[i]로 바꾼다.
//   2-5. 최솟값과 최댓값을 공백으로 구분해 출력한다.

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

            bw.write(min + " " + max + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}