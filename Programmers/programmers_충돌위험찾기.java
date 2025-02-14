// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-PCCP-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-3%EB%B2%88-%EC%B6%A9%EB%8F%8C%EC%9C%84%ED%97%98-%EC%B0%BE%EA%B8%B0

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int workingCount = routes.length;
        int conflictCount = 0;

        int[][] robotPoint = new int [routes.length][2];
        int[][] endPoint = new int[routes.length][2];
        Map<Integer, Integer> endCount = new HashMap<>();

        Set<Integer> checkConflict = new HashSet<>();
        Set<Integer> ConflictPoint = new HashSet<>();
        Map<Integer, Integer> finalPointRobot = new HashMap<>();

        for(int i =0; i<routes.length; i++){
            int startPoint = routes[i][0];
            int endP = routes[i][1];

            robotPoint[i][0] = points[startPoint-1][0];
            robotPoint[i][1] = points[startPoint-1][1];

            endPoint[i][0] = points[endP-1][0];
            endPoint[i][1] = points[endP-1][1];

            finalPointRobot.put(i, 0);
            endCount.put(i, 1);

            int bfSize = checkConflict.size();
            checkConflict.add(robotPoint[i][0]*1000+robotPoint[i][1]);
            if(checkConflict.size() == bfSize){
                ConflictPoint.add(robotPoint[i][0]*1000+robotPoint[i][1]);
            }
        }
        conflictCount += ConflictPoint.size();


        while(workingCount != 0){
            checkConflict.clear();
            ConflictPoint.clear();

            for(int i=0; i<robotPoint.length; i++){
                if(finalPointRobot.get(i) == -1){
                    //System.out.println("들어옴");
                    continue;
                }

                if(robotPoint[i][0] == endPoint[i][0] && robotPoint[i][1] == endPoint[i][1]){
                    if(routes[0].length-1 > endCount.get(i)){
                        int count = endCount.get(i)+1;
                        endCount.put(i, count);
                        int routesNum = routes[i][count]-1;
                        endPoint[i][0] = points[routesNum][0];
                        endPoint[i][1] = points[routesNum][1];
                        //System.out.println("추가됨" + count + i);
                    }else{
                        workingCount--;
                        finalPointRobot.put(i, -1);
                        if(workingCount == 0){
                            break;
                        }
                        continue;
                    }
                }
                if(robotPoint[i][0] < endPoint[i][0]){
                    robotPoint[i][0]++;
                }else if(robotPoint[i][0] > endPoint[i][0]){
                    robotPoint[i][0]--;
                }else{
                    if(robotPoint[i][1] < endPoint[i][1]){
                        robotPoint[i][1]++;
                    }else if(robotPoint[i][1] > endPoint[i][1]){
                        robotPoint[i][1]--;
                    }
                }

                //System.out.println("이동중 "+i+" 번째 : "+ robotPoint[i][0] +"," + robotPoint[i][1]);

                int bfSize = checkConflict.size();
                checkConflict.add(robotPoint[i][0]*1000+robotPoint[i][1]);
                if(checkConflict.size() == bfSize){
                    ConflictPoint.add(robotPoint[i][0]*1000+robotPoint[i][1]);
                    //System.out.println("추가됨");
                }

            }

            conflictCount += ConflictPoint.size();
            //System.out.println("카운트 " + conflictCount);


            if(workingCount == 0){
                break;
            }
        }

        return conflictCount;
    }
}