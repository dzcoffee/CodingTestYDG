// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-30802%EB%B2%88-%EC%9B%B0%EC%BB%B4%ED%82%A4%ED%8A%B8

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int participantNum = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String[] TsizeNum =  str.split(" ");
        str = br.readLine();
        String[] setNum = str.split(" ");
        int T = Integer.parseInt(setNum[0]);
        int Tnum = 0;
        for(int i = 0; i< 6; i++){
            Tnum += ((Integer.parseInt(TsizeNum[i]) / T));
            if((Integer.parseInt(TsizeNum[i]) % T) != 0){
                Tnum ++;
            }
        }
        System.out.println(Tnum);

        int P = Integer.parseInt(setNum[1]);

        System.out.println((participantNum/P)+" "+ (participantNum%P));
    }
}