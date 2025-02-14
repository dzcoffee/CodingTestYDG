// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-2022-KAKAO-BLIND-Recruitment-%EC%8B%A0%EA%B3%A0-%EA%B2%B0%EA%B3%BC-%EB%B0%9B%EA%B8%B0

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> user_id = new HashMap<>();
        Set<String>[] reported_id = new HashSet[id_list.length];

        for(int j=0; j < id_list.length; j++){
            user_id.put(id_list[j],j);
            reported_id[j] = new HashSet<>();
        }

        for(int i =0; i < report.length ; i++){
            String[] str = report[i].split(" ");
            int reported_num = user_id.get(str[1]);
            //System.out.println("reported_num" + reported_num);
            reported_id[reported_num].add(str[0]);
        }

        for(int l =0; l<id_list.length; l++){
            if(reported_id[l].size() >= k){
                for(String reporting_name : reported_id[l]){
                    answer[user_id.get(reporting_name)]++;
                }
            }else{
                continue;
            }
        }

        return answer;
    }
}