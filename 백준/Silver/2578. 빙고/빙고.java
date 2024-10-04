import java.util.*;
import java.io.*;

// 1. 숫자와 체크 유무를 필드로 갖는 클래스(Tile) 선언 (한 타일의 정보를 저장)
// 2. bingo[5][5] 배열 만들고, 입력들을 배열에 저장 (5번째 줄까지)
// 3. 사회자가 숫자를 한 번 부를 때마다 숫자 체크 & 빙고 체크
// 숫자 체크: 숫자를 배열에서 찾아서 체크 유무를 true로 변경
// 빙고 체크: 불린 숫자의 배열 상의 인덱스를 알고 있으니,
//            먼저 대각선 빙고가 되는지 체크한다.
//            해당 숫자의 인덱스를 기준으로 상하좌우로 몇 칸 움직일 수 있는지 계산한다. (대각선 가능할 경우 대각선도 계산)
//            가로 빙고, 세로 빙고를 체크한다. (인덱스로 상하좌우로 몇 칸씩 체크해야 하는지 계산)
//            대각선 빙고가 된다면 대각선 빙고도 체크한다. (마찬가지로 인덱스로 체크)
//            빙고 카운트가 3이 되면 사회자가 부른 숫자의 카운트를 출력한다.
// 대각선 빙고가 되는 인덱스들: (0,0), (1,1), (2,2), (3,3), (4,4) -> x, y 좌표가 같을 때인 경우
//                              (0,4), (1,3), (2,2), (3,1), (4,0) -> x, y 좌표를 더했을 때 4인 경우

public class Main {

    static Tile[][] board = new Tile[5][5];
    static int callCount = 0;
    static int bingoCount = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 빙고판 채우기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 5; j++) {
                board[i][j] = new Tile(Integer.parseInt(st.nextToken()));
            }
        }


        // 빙고 확인하기
        // 사회자가 부른 숫자 저장하기
        int[][] callArr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 5; j++) {
                callArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 하나씩 빙고판에 체크하고 빙고 확인하기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                checkNum(callArr[i][j]);
                callCount++;

                if (bingoCount >= 3) {
                    sb.append(callCount);
                    System.out.println(sb);

                    return;
                }
            }
        }
    }

    // 사회자가 부른 숫자를 빙고판에 표시하고 빙고를 확인하는 메서드
    // 빙고가 확인될 때마다 bingoCount에 +1을 한다.
    public static void checkNum(int num) {

        // 빙고판에서 num의 인덱스를 찾는다.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].num != num) continue;

                board[i][j].isChecked = true;
                    
                boolean canCross = false;

                if (i == j || i + j == 4) {
                    canCross = true;
                }

                // 빙고를 확인한다.
                checkBingo(i, j, canCross);
            
            }
        }
    }

    public static void checkBingo(int i, int j, boolean canCross) {

        // 불린 숫자의 인덱스를 기준으로 상하좌우, 대각선으로 몇 칸 확인해야 하는지 계산
        int left = 0, right = 0, up = 0, down = 0;
        boolean leftBingo = false, 
        rightBingo = false, 
        upBingo = false, 
        downBingo = false;

        left = j;
        right = 4 - j;
        up = i;
        down = 4 - i;

        // 가로줄 빙고 확인
        int count = 0;
        for (int l = 1; l <= left; l++) {
            if (!board[i][j - l].isChecked) break;  // isChecked가 false면 더 이상 볼 것 없이 가로 줄은 빙고 불가능.
            else count++;

            if (count == left) leftBingo = true;
        }

        count = 0;
        for (int r = 1; r <= right; r++) {

            if (!board[i][j + r].isChecked) break;
            else count++;

            if (count == right) rightBingo = true;
        }

        // 끝에 붙어 있어서 반대쪽은 확인 안하는 경우를 위해 보정
        if (j == 0) {
            leftBingo = true;
        }
        else if (j == 4) {
            rightBingo = true;
        }

        if (leftBingo && rightBingo) {
            bingoCount++;
        }

        // 세로줄 빙고 확인
        count = 0;
        for (int u = 1; u <= up; u++) {
            if (!board[i - u][j].isChecked) break;
            else count++;

            if (count == up) upBingo = true;
        }

        count = 0;
        for (int d = 1; d <= down; d++) {
            if (!board[i + d][j].isChecked) break;
            else count++;

            if (count == down) downBingo = true;
        }

        if (i == 0) {
            upBingo = true;
        }
        else if (i == 4) {
            downBingo = true;
        }

        if (upBingo && downBingo) {
            bingoCount++;
        }

        // 대각선 빙고 확인
        if (canCross && i == j) {
            int leftUp = i, rightDown = 4 - i;
            boolean leftUpBingo = false, rightDownBingo = false;

            count = 0;
            for (int lu = 1; lu <= leftUp; lu++) {
                if (!board[i - lu][j - lu].isChecked) break;
                else count++;

                if (count == leftUp) leftUpBingo = true;
            }

            count = 0;
            for (int rd = 1; rd <= rightDown; rd++) {
                if (!board[i + rd][j + rd].isChecked) break;
                else count++;

                if (count == rightDown) rightDownBingo = true;
            }

            if (i == 0) {
                leftUpBingo = true;
            }
            else if (i == 4) {
                rightDownBingo = true;
            }

            if (leftUpBingo && rightDownBingo) {
                bingoCount++;
            }
        }
        if (canCross && i + j == 4) {
            int leftDown = j, rightUp = i;
            boolean leftDownBingo = false, rightUpBingo = false;

            count = 0;
            for (int ld = 1; ld <= leftDown; ld++) {
                if (!board[i + ld][j - ld].isChecked) break;
                else count++;

                if (count == leftDown) leftDownBingo = true;
            }

            count = 0;
            for (int ru = 1; ru <= rightUp; ru++) {
                if (!board[i - ru][j + ru].isChecked) break;
                else count++;

                if (count == rightUp) rightUpBingo = true;
            }

            if (i == 4) {
                leftDownBingo = true;
            }
            else if (i == 0) {
                rightUpBingo = true;
            }

            if (leftDownBingo && rightUpBingo) {
                bingoCount++;
            }
        }
    }
}

class Tile {
    int num;
    boolean isChecked;

    public Tile(int num) {
        this.num = num;
        isChecked = false;
    }
}
