import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numOfSet = new int[10];

        while(n > 0) {

            int digit = n % 10;

            if(digit == 6 || digit == 9) {

                if(numOfSet[6] <= numOfSet[9]) {

                    numOfSet[6]++;
                }
                else {

                    numOfSet[9]++;
                }
            }
            else {
                
                numOfSet[digit]++;
            }

            n /= 10;
        }

        int max = 1;
        for(int i = 0; i < 10; i++) {

            if(max < numOfSet[i]) {

                max = numOfSet[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max);
        System.out.println(sb);
    }
}