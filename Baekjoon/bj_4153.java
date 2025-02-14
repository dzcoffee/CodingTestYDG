// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-4153%EB%B2%88-%EC%A7%81%EA%B0%81%EC%82%BC%EA%B0%81%ED%98%95

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int big = 0;
        int end = 0;

        while(true){
            String str = br.readLine();
            String[] splitLine = str.split(" ");
            int[] lineInt = new int[3];
            for(int i =0; i < 3; i++){
                int temp = Integer.parseInt(splitLine[i]);
                lineInt[i] = temp * temp;
                if(lineInt[0] == 0){
                    end++;
                }
            }
            Arrays.sort(lineInt);
            if(end == 3){
                break;
            }else{
                if(lineInt[2] == lineInt[0] + lineInt[1]){
                    System.out.println("right");
                }else{
                    System.out.println("wrong");
                }
                end = 0;
            }
        }
    }
}