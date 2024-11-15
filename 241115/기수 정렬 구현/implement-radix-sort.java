import java.util.*;
import java.io.*;

public class Main {

    public static ArrayList<Integer> arr;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        int k = 1; // 입력 받은 값의 최대 자리수를 저장하는 변수
        
        // arr에 입력된 값 저장 & 주어진 수들의 최대 자리수 구하기
        for(int i = 0; i < n; i++) {

            arr.add(Integer.parseInt(st.nextToken()));

            int arrCopy = arr.get(i);
            int kp = 1;
            while(arrCopy >= 10) {

                arrCopy /= 10;
                kp++;
            }

            if(kp > k) {
                k = kp;
            }
        }

        // 기수 정렬
        for(int i = 1; i <= k; i++) {

            ArrayList<Integer>[] al = new ArrayList[10];

            for(int j = 0; j < 10; j++) {

                al[j] = new ArrayList<Integer>();
            }

            // 각 수의 자리수를 구하고, 맞는 위치에 저장
            for(int j = 0; j < n; j++) {

                int digit = getDigit(arr.get(j), i);

                al[digit].add(arr.get(j));
            }

            arrayListCopy(al, n);
        }

        ListIterator li = arr.listIterator();
        StringBuilder sb = new StringBuilder();

        while(li.hasNext()) {
            
            sb.append(li.next()).append(" ");
        }

        System.out.println(sb);
    }

    // num의 k번째 자리수를 구함
    public static int getDigit(int num, int k) {
        
        int digit = 0;
        int numCopy = num;

        for(int i = 0; i < k; i++) {

            digit = num % 10;
            num /= 10;
        }

        return digit;
    }

    public static void arrayListCopy(ArrayList<Integer>[] al, int n) {

        arr.clear();

        for(int i = 0; i < 10; i++) {

            for(int j = 0; j < al[i].size(); j++) {

                arr.add(al[i].get(j));
            }
        }
    }
}