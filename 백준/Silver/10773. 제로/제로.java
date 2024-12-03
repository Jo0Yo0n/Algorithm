import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++) {

            int input = Integer.parseInt(br.readLine());
            
            if(input == 0) {

                stack.pop();
            }
            else {

                stack.push(input);
            }
        }

        int sum = 0;

        while(stack.size() > 0) {

            sum += stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        System.out.println(sb);
    }
    
}
