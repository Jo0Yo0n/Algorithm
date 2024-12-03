import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 1; i <= n; i++) {

            ll.add(i);
        }
        ListIterator<Integer> it = ll.listIterator();

        while(ll.size() > 0) {

            for(int i = 0; i < k - 1; i++) {

                if(!it.hasNext()) {

                    it = ll.listIterator();
                }
                it.next();
            }

            if(!it.hasNext()) {

                it = ll.listIterator();
            }

            sb.append(it.next());
            it.remove();

            if(ll.size() == 0) {

                sb.append(">");
            }
            else {

                sb.append(", ");
            }
        }

        System.out.println(sb);
    }
}
