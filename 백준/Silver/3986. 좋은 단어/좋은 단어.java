import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while(n-- > 0) {

            String input = br.readLine();

            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < input.length(); i++) {

                if(i == 0) {
                    
                    stack.addLast(input.charAt(i));
                }
                else if(stack.size() != 0 && stack.peekLast().equals(input.charAt(i))){

                    stack.removeLast();
                }
                else {

                    stack.addLast(input.charAt(i));
                }
            }

            if(stack.size() == 0) {

                ans++;
            }
        }

        System.out.println(ans);
    }
}
