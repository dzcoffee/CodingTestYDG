// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-2020-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EC%9D%B8%ED%84%B4%EC%8B%AD-%ED%82%A4%ED%8C%A8%EB%93%9C-%EB%88%84%EB%A5%B4%EA%B8%B0

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] num = {{1,2,3}, {4,5,6}, {7,8,9}, {-1, 0, -2}};
        int[] left_pos = {3,0};
        int[] right_pos = {3,2};
        String answer = "";
        for(int i =0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer = answer + "L";
                left_pos = indexOf(num, numbers[i]);
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer = answer + "R";
                right_pos = indexOf(num, numbers[i]);
            }else{
                int[] find_pos = indexOf(num, numbers[i]);
                int left_distance = Math.abs(find_pos[0] - left_pos[0]) + Math.abs(find_pos[1] - left_pos[1]);
                int right_distance = Math.abs(find_pos[0] - right_pos[0]) + Math.abs(find_pos[1] - right_pos[1]);
                if(left_distance > right_distance){
                    answer = answer + "R";
                    right_pos = indexOf(num, numbers[i]);
                }else if(left_distance < right_distance){
                    answer = answer + "L";
                    left_pos = indexOf(num, numbers[i]);
                }else{
                    if(hand.equals("left")){
                        answer = answer + "L";
                        left_pos = indexOf(num, numbers[i]);
                    }else{
                        answer = answer + "R";
                        right_pos = indexOf(num, numbers[i]);
                    }
                }
            }
        }


        return answer;
    }

    public static int[] indexOf(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}