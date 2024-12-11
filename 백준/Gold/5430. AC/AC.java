import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            int d = 0;
            boolean isReversed = false;

            for(int j = 0; j < p.length(); j++) {

                if(p.charAt(j) == 'D') d++;
            }

            if(d > n) {

                sb.append("error").append("\n");
                continue;
            }

            for(int j = 0; j < n; j++) {

                if(j == 0) {
                    
                    if(n != 1) {
                        deque.addLast(Integer.parseInt(arr[0].substring(1)));
                    }
                    else {
                        deque.addLast(Integer.parseInt(arr[0].substring(1, arr[0].length() - 1)));
                    }
                }
                else if(j == n - 1) {

                    deque.addLast(Integer.parseInt(arr[j].substring(0, arr[j].length() - 1)));
                }
                else {
                    deque.addLast(Integer.parseInt(arr[j]));
                }
            }

            for(int j = 0; j < p.length(); j++) {

                switch(p.charAt(j)) {

                    case 'R':
                        
                        isReversed = !isReversed;

                        break;

                    case 'D':
                        
                        if(isReversed) {

                            deque.removeLast();
                        }
                        else {

                            deque.removeFirst();
                        }

                        n--;
                        break;
                }
            }

            sb.append("[");
            for(int j = 0; j < n; j++) {

                if(isReversed) {
                    
                    sb.append(deque.pollLast());
                } else {
                    
                    sb.append(deque.pollFirst());
                }

                if(j != n - 1) {

                    sb.append(",");
                }
            }
            sb.append("]").append("\n");
        }

        System.out.println(sb);
    }
}