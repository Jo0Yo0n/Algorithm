import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();  // Queue 역할을 하는 Deque 선언
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {

            deque.addLast(Integer.parseInt(br.readLine()));
        }

        int i = 1;
        while(i <= n) {

            while(i <= deque.peekFirst()) {

                stack.push(i++);
                sb.append("+").append("\n");
            }

            while(stack.size() > 0 && stack.peek().equals(deque.peekFirst())) {

                stack.pop();
                deque.pollFirst();
                sb.append("-").append("\n");
            }

            if(stack.size() > 0 && stack.peek() > deque.peekFirst()) {

                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
