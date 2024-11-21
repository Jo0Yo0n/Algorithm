import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Queue<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "push":
                    
                    int a = Integer.parseInt(st.nextToken());

                    q.add(a);
                    break;
                
                case "pop":

                    sb.append(q.poll()).append("\n");
                    break;

                case "size":

                    sb.append(q.size()).append("\n");
                    break;

                case "empty":

                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":

                    sb.append(q.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}