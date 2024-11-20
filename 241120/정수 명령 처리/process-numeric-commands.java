import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "push":
                    
                    int a = Integer.parseInt(st.nextToken());
                    stack.push(a);
                    break;

                case "pop":

                    sb.append(stack.pop()).append("\n");
                    break;

                case "size":

                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":

                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "top":

                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}