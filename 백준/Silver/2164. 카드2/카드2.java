import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {

            queue.addLast(i);
        }

        while(queue.size() > 1) {

            queue.pollFirst();
            
            if(!queue.isEmpty()) {

                queue.addLast(queue.pollFirst());
            }
        }

        System.out.println(queue.peekFirst());
    }
}
