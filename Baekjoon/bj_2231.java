// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-2231%EB%B2%88-%EB%B6%84%ED%95%B4%ED%95%A9

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int numLong = 0;
        int checkSumLong = sum;
        int answer = 0;

        while(checkSumLong != 0){
            checkSumLong = checkSumLong / 10;
            numLong++;
        }

        for(int i =1; i <= numLong * 9; i++){
            int num = sum - i;
            int checkSum = num;
            for(int j=1; j <= numLong; j++){
                checkSum = checkSum + (num % 10);
                num = num / 10;
            }
            if(checkSum == sum){
                answer = sum - i;
            }
        }
        System.out.println(answer);
    }
}