// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-2292%EB%B2%88-%EB%B2%8C%EC%A7%91

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0; //방 지나간 갯수
        int low = 0;
        int high = 1;

        do{
            low = high +1;
            high = high + 6 *count;
            count ++;
        }
        while(!(low <= num && num <= high) && num != 1);

        System.out.println(count);
    }
}
