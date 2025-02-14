// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.2-%ED%98%B8%ED%85%94-%EB%8C%80%EC%8B%A4

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b)-> a[1] - b[1]);

        int end = -1;

        for(int[] target : targets){
            if(end == -1){
                end = target[1];
                answer++;
            }else{
                if(target[0] >= end){
                    end = target[1];
                    answer++;
                }
            }
        }

        return answer;
    }
}