// Link : https://velog.io/@dzcoffee/JAVA-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8D%A7%EC%B9%A0%ED%95%98%EA%B8%B0

import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int left = section[0];
        int right;
        int answer = 1;

        for(int i=0; i < section.length ; i++){
            right = section[i];
            if((right - left + 1) > m){
                left = section[i];
                answer++;
            }
        }

        return answer;
    }
}