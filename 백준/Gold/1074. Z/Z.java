import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n, r, c;
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    static int func(int n, int r, int c) {
        if(n == 0) {
            return 0;
        }

        int half = 1 << (n-1);
        if(r < half && c < half) return func(n-1, r, c);
        if(r < half && c >= half) return half * half + func(n-1, r, c-half);
        if(r >= half && c < half) return 2 * half * half + func(n-1, r-half, c);
        return 3 * half * half + func(n-1, r-half, c-half);
    }
}
