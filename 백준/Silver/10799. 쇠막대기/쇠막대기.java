import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int temp = 0;
        int ans = 0;

        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '(') {

                temp++;
            }
            else {

                temp--;

                if(input.charAt(i - 1) == '(') {
                    
                    ans += temp;
                }
                else {

                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}

// '('' 보일 때마다 temp에다가 1씩 더함
// ')' 보일 때마다 temp에다가 1씩 뺌. 만약 ')' 바로 앞이 '(' 일 경우 ans에 temp를 더함.
// 바로 앞이 '(' 가 아닐 경우 ans에 1씩 더함.