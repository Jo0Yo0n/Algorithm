import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '(') {

                stack.push('(');
            }
            else {

                if(stack.isEmpty()) {

                    sb.append("No");
                    System.out.println(sb);

                    return;
                }

                stack.pop();
            }
        }

        sb.append(stack.isEmpty() ? "Yes" : "No");

        System.out.println(sb);
    }
}