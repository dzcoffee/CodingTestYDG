// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-1978%EB%B2%88-%EC%86%8C%EC%88%98-%EC%B0%BE%EA%B8%B0

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] numStrList = str.split(" ");
        int findNum = 0;

        for(int i=0; i < num; i++){
            int checkNum = Integer.parseInt(numStrList[i]);
            if(checkNum <= 1){
                findNum ++;
                continue;
            }
            for(int j = 2; j < checkNum; j++){
                if(checkNum % j == 0){
                    findNum++; // 비소수 찾음.
                    break;
                }else{
                    continue;
                }
            }
        }

        num -= findNum;
        System.out.println(num);
    }
}
