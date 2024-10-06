import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        int[] stockPrices = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        
        int bnp = bnp(money, stockPrices);
        int timing = timing(money, stockPrices);

        if (bnp > timing) {
            sb.append("BNP");
        }
        else if (bnp < timing) {
            sb.append("TIMING");
        }
        else {
            sb.append("SAMESAME");
        }

        System.out.println(sb);
        return;
    }

    public static int bnp(int money, int[] stockPrices) {
        
        int numberOfStocks = 0;  // 보유 주식 수

        for (int i = 0; i < stockPrices.length; i++) {
            
            numberOfStocks += money / stockPrices[i];
            money %= stockPrices[i];
        }

        int result = money + numberOfStocks * stockPrices[stockPrices.length - 1];
        return result;
    }

    // 1. 모든 거래는 전량 매수와 전량 매도.
    // 2. 3일 연속 가격이 전일 대비 상승하는 주식은 다음날 무조건 가겨이 하락한다고 가정.
    //    따라서 현재 소유한 주식의 가격이 3일째 상승한다면, 전량 매도.
    // 3. 3일 연속 가격이 전일 대비 하락하는 주식은 다음날 무조건 가격이 상승한다고 가정.
    //    따라서 이러한 경항이 나타나면 즉시 주식을 전량 매수.
    // 경향에 따른 매수/매도가 우선시 되어야 함.
    // 3일 연속 떨어졌는데 그 이후도 계속 떨어지면 살 수 있는만큼 사야함.
    public static int timing(int money, int[] stockPrices) {
        
        int numberOfStocks = 0, yesterDayPrice = 0, tendency = 0;

        for (int i = 0; i < stockPrices.length; i++) {

            if (i != 0) {  // 첫 날인 경우 전일가를 따지지 않음.

                if (yesterDayPrice - stockPrices[i] > 0) {  // 전 날보다 가격이 떨어진 경우

                    if (tendency <= 0) {

                        tendency--;
                    }
                    else {

                        tendency = -1;
                    }
                }
                else if (yesterDayPrice - stockPrices[i] < 0) {  // 전 날보다 가격이 올라간 경우

                    if (tendency >= 0) {

                        tendency++;
                    }
                    else {

                        tendency = 1;
                    }
                }
            }

            // 3일 연속 가격 하락
            if (tendency <= -3) {
                
                numberOfStocks += money / stockPrices[i];
                money %= stockPrices[i];
            }
            // 3일 연속 가격 상승
            else if (tendency >= 3) {

                money += stockPrices[i] * numberOfStocks;
                numberOfStocks = 0;
            }

            yesterDayPrice = stockPrices[i];
        }

        int result = money + numberOfStocks * stockPrices[stockPrices.length - 1];
        return result;
    }
}
