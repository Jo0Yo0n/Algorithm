import java.io.*;

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int count = (int)Math.pow(2, n) - 1;

        sb.append(count).append("\n");

        func(1, 3, n);

        System.out.println(sb);
    }

    public static void func(int a, int b, int n) {
        if(n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        func(a, 6-a-b, n-1);
        sb.append(a).append(" ").append(b).append("\n");
        func(6-a-b, b, n-1);
    }
}
