// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.2-%EA%B3%BC%EC%A0%9C-%EC%A7%84%ED%96%89%ED%95%98%EA%B8%B0

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        int time = 0;
        int nowOnIndex = 0;
        int nowOnTime = -1;

        List<Integer> rdyStack = new ArrayList<>();
        List<Integer> remainList = new ArrayList<>();

        int idx = 0;
        for(String[] planTest : plans){
            remainList.add(Integer.valueOf(idx));
            idx++;
        }


        while(plans.length!= answerList.size()){
            if(nowOnTime == 0){
                //System.out.println("테스트");
                answerList.add(plans[nowOnIndex][0]);
                nowOnTime = -1;
                if(!rdyStack.isEmpty()){
                    nowOnIndex = rdyStack.get(rdyStack.size() - 1);
                    nowOnTime = Integer.parseInt(plans[nowOnIndex][2]);
                    rdyStack.remove(rdyStack.size() - 1);
                }else{
                    nowOnTime = -1;
                }
            }

            for(int planIdx : remainList){
                String[] splitTime = plans[planIdx][1].split(":");
                int hour = Integer.parseInt(splitTime[0]);
                int minute = Integer.parseInt(splitTime[1]);
                int planTime = hour*60 + minute;

                if(planTime == time){
                    if(nowOnTime != -1){
                        rdyStack.add(nowOnIndex);
                        plans[nowOnIndex][2] = String.valueOf(nowOnTime);
                    }
                    nowOnIndex = planIdx;
                    nowOnTime = Integer.parseInt(plans[planIdx][2]);
                }
            }
            time++;
            if(nowOnTime != -1){
                if(remainList.contains(nowOnIndex)){
                    remainList.remove(Integer.valueOf(nowOnIndex));
                }
                nowOnTime--;
            }
        }

        String[] answer = answerList.toArray(new String[0]);
        return answer;
    }
}