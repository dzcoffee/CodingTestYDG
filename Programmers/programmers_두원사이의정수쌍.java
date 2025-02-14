// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.2-%EB%91%90-%EC%9B%90-%EC%82%AC%EC%9D%B4%EC%9D%98-%EC%A0%95%EC%88%98-%EC%8C%8D

import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        int y2;
        int y1;

        for(long i =1; i<=r2; i++){
            y2 = (int) Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            if( r1 < i){
                y1 = 0;
            }else{
                y1 = (int) Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
            }
            answer += y2-y1+1;
            //System.out.println(" y2 : " + y2 + " y1 : " + y1);
        }

        answer = answer*4;

        return answer;
    }
}