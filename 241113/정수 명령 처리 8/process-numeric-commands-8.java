import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> ll = new LinkedList<>();

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch(command) {

                case "push_front":
                    int a = Integer.parseInt(st.nextToken());
                    ll.addFirst(a);
                    break;

                case "push_back":
                    int b = Integer.parseInt(st.nextToken());
                    ll.addLast(b);
                    break;

                case "pop_front":
                    sb.append(ll.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    sb.append(ll.pollLast()).append("\n");
                    break;

                case "size":
                    sb.append(ll.size()).append("\n");
                    break;

                case "empty":
                    sb.append(ll.isEmpty() ? 1 : 0).append("\n");
                    break;
                
                case "front":
                    sb.append(ll.peekFirst()).append("\n");
                    break;

                case "back":
                    sb.append(ll.peekLast()).append("\n");
                    break;

                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}