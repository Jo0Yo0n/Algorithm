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
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
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

                deque.addLast(Integer.parseInt(st.nextToken()));
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