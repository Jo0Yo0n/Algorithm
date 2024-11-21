import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '(') {

                stack.push('(');
            }
            if(!stack.isEmpty() && input.charAt(i) == ')') {

                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(stack.isEmpty() ? "Yes" : "No");

        System.out.println(sb);
    }
}