// Link : https://velog.io/@dzcoffee/JAVA-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B6%94%EC%96%B5-%EC%A0%90%EC%88%98

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> name_year = new HashMap<>();
        int[] answer = new int[photo.length];

        for(int j=0; j< name.length; j++){
            name_year.put(name[j], yearning[j]);
        }

        for(int i =0; i<photo.length; i++){
            int sum = 0;
            for(int k=0; k<photo[i].length; k++){
                Integer get_value = name_year.get(photo[i][k]);
                if(get_value != null){
                    sum += get_value.intValue();
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}