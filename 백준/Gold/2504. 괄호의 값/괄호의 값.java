import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int ans = 0;
        int level = 0;
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Pair> temp = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '(') {
                
                level++;
                stack.addLast('(');
            }
            else if(input.charAt(i) == '[') {

                level++;
                stack.addLast('[');
            }
            else if(input.charAt(i) == ')' && stack.size() != 0 && stack.peekLast() == '(') {

                stack.removeLast();

                int sum = 0;

                while(temp.size() != 0 && temp.peekLast().level == level + 1) {

                    sum += temp.pollLast().value;
                }

                sum = (sum == 0) ? 2 : sum * 2;

                temp.addLast(new Pair(sum, level));
                level--;
            }
            else if(input.charAt(i) == ']' && stack.size() != 0 && stack.peekLast() == '[') {

                stack.removeLast();

                int sum = 0;

                while(temp.size() != 0 && temp.peekLast().level == level + 1) {

                    sum += temp.pollLast().value;
                }

                sum = (sum == 0) ? 3 : sum * 3;

                temp.addLast(new Pair(sum, level));
                level--;
            }
            else {

                System.out.println(0);
                return;
            }
        }

        if(stack.size() != 0) {

            System.out.println(0);
            return;
        }

        while(temp.size() != 0) {

            ans += temp.pollLast().value;
        }

        System.out.println(ans);
    }
}

class Pair {
    public int value;
    public int level;

    public Pair(int value, int level) {

        this.value = value;
        this.level = level;
    }
}
