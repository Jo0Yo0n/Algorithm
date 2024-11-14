import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        LinkedList<Character> bread = new LinkedList<>();
        String str = br.readLine();

        for(int i = 0; i < n; i++) {
            bread.add(str.charAt(i));
        }

        ListIterator li = bread.listIterator(bread.size());

        for(int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "L":
                    if(li.hasPrevious()) {
                        li.previous();
                    }
                    break;

                case "R":
                    if(li.hasNext()) {
                        li.next();
                    }
                    break;

                case "D":
                    if(li.hasNext()) {
                        li.next();
                        li.remove();
                    }
                    break;

                case "P":
                    li.add(st.nextToken().charAt(0));
                    break;

                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        ListIterator li2 = bread.listIterator();

        for(int i = 0; i < bread.size(); i++) {
            
            sb.append(li2.next());
        }

        System.out.println(sb);
    }
}