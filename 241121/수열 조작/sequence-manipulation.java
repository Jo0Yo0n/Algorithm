import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {

            deque.addLast(i);
        }

        while(deque.size() != 1) {

            deque.pollFirst();

            deque.addLast(deque.pollFirst());
        }

        StringBuilder sb = new StringBuilder();

        sb.append(deque.peekLast());

        System.out.println(sb);
    }
}