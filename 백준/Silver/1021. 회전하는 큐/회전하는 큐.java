import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        
        for(int i = 0; i < m; i++) {

            int target = Integer.parseInt(st.nextToken());

            Deque<Integer> leftDeque = new ArrayDeque<>(deque);
            Deque<Integer> rightDeque = new ArrayDeque<>(deque);
            int left = 0;
            int right = 0;

            while(leftDeque.peekFirst() != target) {

                leftDeque.addLast(leftDeque.pollFirst());
                left++;
            }
            leftDeque.removeFirst();

            while(rightDeque.peekFirst() != target) {

                rightDeque.addFirst(rightDeque.pollLast());
                right++;
            }
            rightDeque.removeFirst();

            if(left < right) {

                deque = leftDeque;
                sum += left;
            }
            else {

                deque = rightDeque;
                sum += right;
            }
        }

        System.out.println(sum);
    }
}

// 큐 맨 앞의 값에서 target을 뺀 값이 반드시 두 수 사이의 거리를 의미하지 않는다.
// 양 쪽 회전 다 해보고 더 적게 걸리는 쪽을 선택한다.