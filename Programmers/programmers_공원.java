// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-PCCE-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-10%EB%B2%88-%EA%B3%B5%EC%9B%90

import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int x_long = park[0].length; //8
        int y_long = park.length; //6
        int mat_num = 0;
        int numberOfMaxMat = mats.length;

        Arrays.sort(mats);
        int min_mat = mats[mat_num]; //2

        for(int i = 0; i < y_long - min_mat + 1; i++){
            for(int j = 0; j < x_long - min_mat + 1; j++){
                if(park[i][j].equals("-1")){
                    int flag = 0;
                    for(int k =0; k < min_mat; k++){
                        for(int l = 0; l < min_mat; l++){
                            if(park[i+k][j+l].equals("-1")){
                                continue;
                            }else{
                                flag = -1;
                                break;
                            }
                        }
                        if(flag == -1){
                            break;
                        }
                    }
                    if(flag == 0){
                        answer = min_mat;
                        mat_num++;
                        if(mat_num == numberOfMaxMat){
                            return answer;
                        }
                        else{
                            min_mat = mats[mat_num];
                        }
                    }
                    if(!(i < y_long - min_mat + 1)){
                        break;
                    }
                }
            }
        }

        return answer;
    }
}