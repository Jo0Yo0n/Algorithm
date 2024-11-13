import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            switch(command) {

                case "push_back":
                    int A = Integer.parseInt(st.nextToken());
                    arr.add(A);
                    break;
                
                case "pop_back":
                    arr.remove(arr.size() - 1);
                    break;
                
                case "size":
                    sb.append(arr.size()).append("\n");
                    break;
                
                case "get":
                    int k = Integer.parseInt(st.nextToken());
                    sb.append(arr.get(k - 1)).append("\n");
                    break;
                
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}