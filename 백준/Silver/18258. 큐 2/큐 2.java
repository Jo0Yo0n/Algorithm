import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "push":
                    
                    int x = Integer.parseInt(st.nextToken());

                    queue.addLast(x);
                    break;
                
                case "pop":

                    if(queue.isEmpty()) {

                        sb.append("-1").append("\n");
                    }
                    else {

                        sb.append(queue.pollFirst()).append("\n");
                    }
                    break;

                case "size":

                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":

                    if(queue.isEmpty()) {

                        sb.append("1").append("\n");
                    }
                    else {

                        sb.append("0").append("\n");
                    }
                    break;

                case "front":
                    
                    if(queue.isEmpty()) {

                        sb.append("-1").append("\n");
                    }
                    else {

                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;

                case "back":

                    if(queue.isEmpty()) {

                        sb.append("-1").append("\n");
                    }
                    else {
                        
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
