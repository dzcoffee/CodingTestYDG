// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-PCCP-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-2%EB%B2%88-%ED%8D%BC%EC%A6%90-%EA%B2%8C%EC%9E%84-%EC%B1%8C%EB%A6%B0

import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int MAX_DIFF = 0;
        for(int j=0; j<diffs.length; j++){
            if(MAX_DIFF < diffs[j]){
                MAX_DIFF = diffs[j];
            }
        }

        int answer = 0;
        int max_range = MAX_DIFF;
        int min_range = 1;
        int level = (min_range + max_range)/2;
        int check = 0;

        while(true){
            if(min_range > max_range){
                break;
            }

            check = 0;
            check = find_solution(level, diffs, times, limit);

            if(check == -1){ // 해당 값은 limit 초과일시
                min_range = level+1;
            }else{
                max_range = level-1;
                answer = level;
            }
            level = (min_range + max_range)/2;

        }

        return answer;
    }

    public int find_solution(int level, int[] diffs, int[] times, long limit){
        int answer = 0;
        long time = 0;
        int flag = 0;
        for(int i=0; i< diffs.length; i++){ // level 하나로 퍼즐 다 돌리기 최종 time은 나올 것
            if(level >= diffs[i]){
                time += times[i];
            }else{
                int repeat = diffs[i]-level;
                time += ((times[i-1] + times[i]) * repeat) + times[i];
            }

            if(time > limit){
                return -1;
            }
        }
        return answer;
    }
}