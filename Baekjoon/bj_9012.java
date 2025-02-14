// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%B0%B1%EC%A4%80-9012%EB%B2%88-%EA%B4%84%ED%98%B8

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i< n ; i++){
            String str = br.readLine();
            int front = 0;
            int back = 0;
            int check = 0;
            for(int j =0; j< str.length(); j++){
                if(str.charAt(j) == '('){
                    front++;
                }
                else if(str.charAt(j) == ')'){
                    back++;
                }
                if(back > front){
                    System.out.println("NO");
                    check = -1;
                    break;
                }
            }
            if(front == back){
                System.out.println("YES");
            }
            else if(check != -1){
                System.out.println("NO");
            }
        }
    }
}