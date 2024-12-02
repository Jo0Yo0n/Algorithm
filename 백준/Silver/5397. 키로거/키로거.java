import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {

            String input = br.readLine();

            LinkedList<Character> ll = new LinkedList<>();
            ListIterator<Character> it = ll.listIterator();

            for(int j = 0; j < input.length(); j++) {

                if(input.charAt(j) == '<') {
                    
                    if(it.hasPrevious()) {

                        it.previous();
                    }
                }
                else if(input.charAt(j) == '>') {

                    if(it.hasNext()) {

                        it.next();
                    }
                }
                else if(input.charAt(j) == '-') {

                    if(it.hasPrevious()) {

                        it.previous();
                        it.next();
                        it.remove();
                    } 
                }
                else {
                    it.add(input.charAt(j));
                }
            }

            it = ll.listIterator();

            while(it.hasNext()) {

                sb.append(it.next());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
