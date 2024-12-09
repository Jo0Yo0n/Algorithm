import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Pair> tower = new ArrayDeque<>();
        Deque<Pair> stack = new ArrayDeque<>();
        int[] answer = new int[n + 1];

        for(int i = 1; i <= n; i++) {

            tower.addLast(new Pair(Integer.parseInt(st.nextToken()), i));
        }

        while(!tower.isEmpty()) {

            while(!stack.isEmpty() && tower.peekLast().num > stack.peekLast().num) {

                answer[stack.pollLast().pos] = tower.peekLast().pos;
            }

            stack.addLast(tower.pollLast());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {

            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    static class Pair {

        int num;
        int pos;
    
        public Pair(int num, int pos) {
    
            this.num = num;
            this.pos = pos;
        }
    }
}

// 1. 2개의 stack을 준비
// tower: 입력받은 탑들을 저장
// stack: 아직 수신하는 탑을 못찾은 tower의 top보다 오른쪽에 있는 탑들을 저장)
// 2. 입력받은 순서대로 tower에 삽입
// 3. stack에서 나온 탑의 값과 tower에 있는 탑의 값을 비교해서 수신하면, 
//    tower에 있는 탑의 번호를 answer[stack에 있는 탑의 번호]에 저장 후 stack pop.
//    stack의 다음 값을 비교 (수신 못하는 탑이 나올 때까지)
// 4. tower에 있는 값을 pop하고 stack으로 이동
// stack에 저장되는 값은 반드시 내림차순으로 저장됨(tower의 최상단에 stack의 최상단 탑보다 큰 탑이 있었으면 수신을 받았을 것이기 때문)
// -> 따라서 stack의 최상단이 수신 받는 탑을 못찾으면 그 밑의 탑도 못찾음. 즉, 더 찾을 필요 없음.