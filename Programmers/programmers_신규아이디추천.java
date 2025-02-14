// Link : https://velog.io/@dzcoffee/Java-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-2021-KAKAO-BLIND-RECRUITMENT-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C

import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        if(!new_id.isEmpty()){
            if(new_id.charAt(0) == '.'){
                new_id = new_id.substring(1);
            }
        }
        if(!new_id.isEmpty()){
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }



        if(new_id.isEmpty()){
            new_id = "a";
        }

        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        while(new_id.length() < 3){
            new_id = new_id + new_id.charAt(new_id.length() - 1);
            System.out.println(new_id.charAt(new_id.length() - 1));
        }

        String answer = new_id;

        return answer;
    }
}
